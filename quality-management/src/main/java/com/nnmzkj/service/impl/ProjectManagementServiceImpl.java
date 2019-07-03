package com.nnmzkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.common.utils.FileUtils;
import com.nnmzkj.dao.QualityProManagementMapper;
import com.nnmzkj.dao.SysAssetMapper;
import com.nnmzkj.dao.SysOrgMapper;
import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.dto.ObjectManagementListDto;
import com.nnmzkj.dto.UpdateProjectInfoDto;
import com.nnmzkj.model.QualityProManagement;
import com.nnmzkj.model.SysAsset;
import com.nnmzkj.service.ProjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;



import java.util.*;

@Service
public class ProjectManagementServiceImpl implements ProjectManagementService {

    @Autowired
    private QualityProManagementMapper proManagementMapper;

    @Autowired
    private SysAssetMapper sysAssetMapper;

    @Autowired
    private SysOrgMapper sysOrgMapper;


    @Value("${global-config.filePath}")
    private String uploadPath;

    @Override
    public PageInfo getManagementList(BaseListParameterDto pageMsg) {
        PageHelper.startPage(pageMsg.getPageNumber(),pageMsg.getPageSize());
        List<ObjectManagementListDto> list = proManagementMapper.selectAll(pageMsg.getBuildId());
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Transactional
    @Override
    public void addProject(AddManagementDto addManagementDto) {
        QualityProManagement proManagement = new QualityProManagement();
        proManagement.setProName(addManagementDto.getProName());
        proManagement.setBuildId(addManagementDto.getBuildId());
        proManagement.setRemark(addManagementDto.getRemark());
        proManagement.setStartFile(addManagementDto.getStartFile());
        proManagement.setGmtCreate(new Date());
        proManagement.setGmtLastModified(new Date());
        proManagement.setBuildName(addManagementDto.getBuildName());
        proManagementMapper.insertSelective(proManagement);

     /*   proManagementMapper.addProject(addManagementDto);
        Long objectKey = addManagementDto.getProId();*/

     /*   MultipartFile blFile = addManagementDto.getBlFile();
        String fileName = "";
        //完整url
        String filePath = FileUtils.filePath(blFile, uploadPath);
        *//*if ( blFile != null &&!blFile.isEmpty()){
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
        }*//*
        addManagementDto.setStartFile(filePath);
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
        }*/
    }

    @Override
    public QualityProManagement  toUpdate(Long proId) {
        return proManagementMapper.selectByPrimaryKey(proId);
    }

    @Transactional
    @Override
    public void updateProject(UpdateProjectInfoDto updateProjectInfoDto) {
        QualityProManagement proManagement = new QualityProManagement();
        proManagement.setProId(updateProjectInfoDto.getProId());
        proManagement.setRemark(updateProjectInfoDto.getRemark());
        proManagement.setStartFile(updateProjectInfoDto.getStartFile());
        //更新项目表
        proManagementMapper.updateByPrimaryKeySelective(proManagement);
    }

    @Transactional
    @Override
    public void deleteByLogic(List<Long> list) {
        if (!StringUtils.isEmpty(list) && list.size() >0){
            proManagementMapper.deleteByLogic(list);
            //删除资源文件
            sysAssetMapper.batchDelete(list);
        }
    }

    @Transactional
    @Override
    public void deleteAsset(Long proId) {
        if (!StringUtils.isEmpty(proId)){
            proManagementMapper.deleteByPrimaryKey(proId);
            //删除资源文件
            sysAssetMapper.deleteByProId(proId);
        }
    }


    /*private String executeUpload(String uploadDir, MultipartFile file,String suffix) throws Exception {
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
    }*/


}
