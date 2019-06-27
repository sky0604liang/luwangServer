package com.nnmzkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.core.PageMsg;
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
import java.util.List;
import java.util.UUID;

@Service
public class ObjectManagementServiceImpl implements ObjectManagementService {

    @Autowired
    private QualityProManagementMapper qualityProManagementMapper;

    @Value("${file.address}") private String uploadPath;

    @Override
    public PageInfo getManagementList(PageMsg pageMsg) {
        PageHelper.startPage(pageMsg.getPage(),pageMsg.getSize());
        List<ObjectManagementListDto> list = qualityProManagementMapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int addObject(AddManagementDto addManagementDto  ) {
        MultipartFile blFile = addManagementDto.getBlFile();
        if (!blFile.isEmpty()){
            String uploadDir = uploadPath;
            String fileName = "";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();

            }
            try {
                fileName = executeUpload(uploadDir, addManagementDto.getBlFile());
            } catch (Exception e) {
                e.printStackTrace();
            }

            // String oldFileName = blFile.getOriginalFilename();
          /*  //图片路径
           // String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/upload/bl";
            String path= "D:/img/;";
            try {
                path = ResourceUtils.getURL("classpath:").getPath()+"/static/up/";
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String randomStr = UUID.randomUUID().toString();
            String newFileName = randomStr + oldFileName.substring(oldFileName.lastIndexOf("."));
            File file = new File(path,newFileName);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            try {
                *//**
                 * 将接收到的文件传输到给定的目标文件。
                 *//*
                blFile.transferTo(file);
                System.out.println(path +newFileName);
            } catch (IOException e) {
                throw new QualityManagementException(QualityManagementExceptionCode.FILE_PATH_IS_NULL);
            }
            // blFile.transferTo(file);*/
        }

        //int status =qualityProManagementMapper.addObject(addManagementDto);
       return 0;
    }


    private String executeUpload(String uploadDir, MultipartFile file) throws Exception {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
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
                e.printStackTrace();
            }
        }
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);

        return filename;
    }


}
