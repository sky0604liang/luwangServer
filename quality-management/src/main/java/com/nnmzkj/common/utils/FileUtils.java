package com.nnmzkj.common.utils;

import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FileUtils {



    private static List<String> accTypes = Arrays.asList(".jpg",".jpeg",".gif",".pdf",".png");

    public static String filePath(MultipartFile file,String uploadPath){
        if ( file != null &&!file.isEmpty()){
            //格式校验
            String suffix =file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = "";
            if(!accTypes.contains(suffix)){
                throw new QualityManagementException(QualityManagementExceptionCode.FILE_FORMAT_IS_ERROR);
            }
            File dir = new File(uploadPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            try {
                fileName = executeUpload(uploadPath, file,suffix);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //存储目录+文件名称 = 完整文件路径
            String filePath =  uploadPath + fileName ;
            return  filePath;
        }
        return null;
    }

    private static String executeUpload(String uploadDir, MultipartFile file,String suffix) throws Exception {
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
