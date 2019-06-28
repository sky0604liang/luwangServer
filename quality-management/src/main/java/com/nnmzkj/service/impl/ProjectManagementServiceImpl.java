package com.nnmzkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.dao.QualityProManagementMapper;
import com.nnmzkj.dao.SysAssetMapper;
import com.nnmzkj.dao.SysOrgMapper;
import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.ObjectManagementListDto;
import com.nnmzkj.dto.UpdateProjectInfoDto;
import com.nnmzkj.model.SysAsset;
import com.nnmzkj.model.SysOrg;
import com.nnmzkj.service.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;


import java.io.IOException;
import java.util.*;

@Service
public class ProjectManagementServiceImpl implements ProjectManagementService {

    @Autowired
    private QualityProManagementMapper qualityProManagementMapper;

    @Autowired
    private SysAssetMapper sysAssetMapper;

    @Autowired
    private SysOrgMapper sysOrgMapper;

    private static List<String> accTypes = Arrays.asList(".jpg",".jpeg",".gif",".pdf",".png");

    private String imgPath = "D://uploadFiles/img/";

    @Value("${file.address}")
    private String uploadPath;

    @Override
    public PageInfo getManagementList(PageMsg pageMsg) {
        PageHelper.startPage(pageMsg.getPage(),pageMsg.getSize());
        List<ObjectManagementListDto> list = qualityProManagementMapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Transactional
    @Override
    public void addProject(AddManagementDto addManagementDto) {
        MultipartFile blFile = addManagementDto.getBlFile();
        String fileName = "";
        if ( blFile != null &&!blFile.isEmpty()){
            //格式校验
            String suffix = addManagementDto.getBlFile().getOriginalFilename().substring(addManagementDto.getBlFile().getOriginalFilename().lastIndexOf("."));
            if(!accTypes.contains(suffix)){
                throw new QualityManagementException(QualityManagementExceptionCode.FILE_FORMAT_IS_ERROR);
            }
            if (!suffix.equals(".pdf")){
                uploadPath = imgPath;
            }
            String uploadDir = uploadPath;
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            try {
                fileName = executeUpload(uploadDir, addManagementDto.getBlFile(),suffix);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //存储目录+文件名称 = 完整文件路径
           String filePath =  uploadDir + fileName ;
           addManagementDto.setStartFile(filePath);
        }
        //存入数据库
        int status = qualityProManagementMapper.selectObjectInfo(addManagementDto.getProName());
        if (status >0){
            throw new QualityManagementException(QualityManagementExceptionCode.OBJECT_IS_MORE);
        }else {
            qualityProManagementMapper.addProject(addManagementDto);
            Long objectKey = addManagementDto.getProId();
            //存入资源表
            SysAsset sysAsset = new SysAsset(addManagementDto.getStartFile(),fileName,addManagementDto.getBlFile().getSize(),new Date(),objectKey);
            sysAssetMapper.insertSelective(sysAsset);
        }
    }

    @Override
    public Map<String,Object>  toUpdate(Long proId) {
        UpdateProjectInfoDto updateProjectInfoDto = qualityProManagementMapper.toUpdate(proId);
        Map<String,Object> map = new HashMap<>();
        map.put("projectInfo",updateProjectInfoDto);
        List<SysAsset> list = sysAssetMapper.getProjectAssetByProId(proId);
        map.put("sysAssetList",list);
        return map;
    }

    @Transactional
    @Override
    public void updateProject(UpdateProjectInfoDto updateProjectInfoDto) {
        //更新项目表
        qualityProManagementMapper.updateProject(updateProjectInfoDto);
        //更新机构办
        if (StringUtil.isNotEmpty(updateProjectInfoDto.getBuildName())){
            sysOrgMapper.updateOrgNameByOrgId(updateProjectInfoDto.getBuildName(),updateProjectInfoDto.getBuildId());
        }
    }


    private String executeUpload(String uploadDir, MultipartFile file,String suffix) throws Exception {
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);

        if(!serverFile.exists()) {
            //先得到文件的上级目录，并创建上级目录，在创建文件
            serverFile.getParentFile().mkdir();
            try {
                //创建文件
                serverFile.createNewFile();
            } catch (IOException e) {

            }
        }
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
        return filename;
    }


}
