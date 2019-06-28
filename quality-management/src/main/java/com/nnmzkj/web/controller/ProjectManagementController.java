package com.nnmzkj.web.controller;


import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.config.log.MyLog;
import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.UpdateProjectInfoDto;
import com.nnmzkj.model.SysOrg;
import com.nnmzkj.service.ProjectManagementService;
import com.nnmzkj.service.SysAssetService;
import com.nnmzkj.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/object/management")
public class ProjectManagementController {

    @Autowired
    private ProjectManagementService projectManagementService;

    @Autowired
    private SysOrgService sysOrgService;

    @Autowired
    private SysAssetService sysAssetService;

    //项目管理列表
    @GetMapping("/list")
    public PageInfo getManagementList(PageMsg pageMsg){
        if (StringUtils.isEmpty(pageMsg)){
            throw new QualityManagementException(QualityManagementExceptionCode.PAGE_IS_NULL);
        }
        PageInfo list = projectManagementService.getManagementList(pageMsg);
        return  list;
    }

    @MyLog(value = "新增项目")  //这里添加了AOP的自定义注解
    //新增项目管理
    @PostMapping("/add/object")
    public Result addProject(AddManagementDto addManagementDto){
        if (StringUtils.isEmpty(addManagementDto) && StringUtil.isNotEmpty(addManagementDto.getProName())){
            throw new QualityManagementException(QualityManagementExceptionCode.OBJECT_NAME_IS_NULL);
        }
        projectManagementService.addProject(addManagementDto);
        return ResultGenerator.genSuccessResult();
    }


    @GetMapping("/to/add")
    public void toAddInfo(){
        //获取所有机构
        List<SysOrg> orgList = sysOrgService.getAllOrg();
    }

    @GetMapping("/to/update")
    public Result toUpdate(Long proId){
        Map<String, Object> map = projectManagementService.toUpdate(proId);
        return ResultGenerator.genSuccessResult(map);
    }

    @MyLog(value = "编辑项目信息")  //这里添加了AOP的自定义注解
    //编辑项目信息
    @PostMapping("update/project")
    public void updateProject(@RequestBody UpdateProjectInfoDto updateProjectInfoDto){
        projectManagementService.updateProject(updateProjectInfoDto);
    }

    @MyLog(value = "删除项目文件")  //这里添加了AOP的自定义注解
    //编辑项目信息
    @DeleteMapping("delete/asset")
    public void deleteAsset(Long assetId){
        sysAssetService.deleteAsset(assetId);
    }

}