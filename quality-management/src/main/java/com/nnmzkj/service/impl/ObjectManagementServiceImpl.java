package com.nnmzkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.dao.QualityProManagementMapper;
import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.ObjectManagementListDto;
import com.nnmzkj.service.ObjectManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ObjectManagementServiceImpl implements ObjectManagementService {

    @Autowired
    private QualityProManagementMapper qualityProManagementMapper;

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

    @Override
    public void addObject(AddManagementDto addManagementDto) {
        MultipartFile blFile = addManagementDto.getBlFile();
        if (!blFile.isEmpty()){
            String fileName = "";
            //格式校验
            String suffix = addManagementDto.getBlFile().getOriginalFilename().substring(addManagementDto.getBlFile().getOriginalFilename().lastIndexOf("."));
            if(!accTypes.contains(suffix)){
                throw new QualityManagementException(QualityManagementExceptionCode.FILE_FORMAT_IS_ERRO);
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
        //存入资源表

        //存入数据库
        qualityProManagementMapper.addObject(addManagementDto);
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
