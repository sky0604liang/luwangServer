package com.nnmzkj.web.controller;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.nnmzkj.common.Test;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.common.utils.FileUtils;
import com.nnmzkj.config.log.MyLog;
import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.dto.ListDto;
import com.nnmzkj.dto.UpdateProjectInfoDto;
import com.nnmzkj.model.QualityProManagement;
import com.nnmzkj.model.SysOrg;
import com.nnmzkj.service.ProjectManagementService;
import com.nnmzkj.service.SysAssetService;
import com.nnmzkj.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/project/management")
public class ProjectManagementController {

    @Value("${global-config.filePath}")
    private String filePath;

    @Autowired
    private ProjectManagementService projectManagementService;

    @Autowired
    private SysOrgService sysOrgService;

    @Autowired
    private SysAssetService sysAssetService;


    @GetMapping("/index")
    public String index() {
        return "/roadNetHtml/index.html";
    }

    @GetMapping("/to/list")
    public String toList() {
        return "/roadNetHtml/projectManage/projectList.html";
    }


    //项目管理列表
    @GetMapping("/list")
    @ResponseBody
    public Test getManagementList(BaseListParameterDto pageMsg) {
        Test test = new Test();
        if (StringUtils.isEmpty(pageMsg)) {
            throw new QualityManagementException(QualityManagementExceptionCode.PAGE_IS_NULL);
        }
        PageInfo pageInfo = projectManagementService.getManagementList(pageMsg);
        long total = pageInfo.getTotal();
        test.setTotal(total);
        test.setRows(pageInfo.getList());
        return test;
    }

    @MyLog(value = "新增项目")
    @PostMapping("/add")
    public void addProject(@RequestBody AddManagementDto addManagementDto, HttpServletResponse response) throws IOException {
        if (StringUtils.isEmpty(addManagementDto) && StringUtil.isNotEmpty(addManagementDto.getProName())) {
            throw new QualityManagementException(QualityManagementExceptionCode.OBJECT_NAME_IS_NULL);
        }
        projectManagementService.addProject(addManagementDto);
    }


    @GetMapping("/to/add")
    public void toAddInfo() {
        //获取所有机构
        List<SysOrg> orgList = sysOrgService.getAllOrg();
    }

    @GetMapping("/to/update")
    public ModelAndView toUpdate(Long proId) {
        QualityProManagement proManagement = projectManagementService.toUpdate(proId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/roadNetHtml/projectManage/edit.html");
        mv.addObject("proManagement", proManagement);
        return mv;

    }

    @MyLog(value = "编辑项目信息")
    //编辑项目信息
    @PostMapping("/update")
    public String updateProject(@RequestBody UpdateProjectInfoDto updateProjectInfoDto) {
        projectManagementService.updateProject(updateProjectInfoDto);
        return "/roadNetHtml/projectManage/projectList.html";
    }

    @MyLog(value = "批量删除项目信息")
    @PostMapping("/batch/delete")
    public int deleteByLogic(@RequestParam("list") List<Long> list) {
        projectManagementService.deleteByLogic(list);
        return 0;
    }


    @MyLog(value = "单个删除删除项目")
    //编辑项目信息
    @PostMapping("/delete")
    public void deleteAsset(Long proId) {
        projectManagementService.deleteAsset(proId);
    }


    /**
     * 多文件具体上传时间，主要是使用了MultipartHttpServletRequest和MultipartFile
     *
     * @param request
     * @return
     */
    @PostMapping("/upload/file")
    @ResponseBody
    public Map<String, String> uploadFile(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    stream = null;
                    return null;
                }
            } else {
                return null;
            }
        }
        return null;
    }




}