package com.nnmzkj.common.utils;


import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public class FileUtils {



    /**
     *
     * @param request
     * @param filePath
     * @return
     */
    public static String tranferFile(HttpServletRequest request, String filePath){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //先判断request中是否包涵multipart类型的数据，
        if(multipartResolver.isMultipart(request)){
            //再将request中的数据转化成multipart类型的数据
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                MultipartFile file = multiRequest.getFile((String)iter.next());
                if(file != null){
                    String originalFileName = file.getOriginalFilename();

                    String path =request.getSession().getServletContext().getRealPath(filePath);
                    //得到存储到本地的文件名
                    String localFileName= UUID.randomUUID().toString()+getFileSuffix(originalFileName);
                    //新建本地文件
                    File localFile = new File(path,localFileName);
                    //创建目录
                    File fileDir=new File(path);
                    if (!fileDir.isDirectory()) {
                        // 如果目录不存在，则创建目录
                        fileDir.mkdirs();
                    }
                    String src=filePath+"/"+localFileName;
                    //写文件到本地
                    try {
                        file.transferTo(localFile);
                        return src;
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
    /**
     * 获取文件后缀
     * @param originalFileName
     * @return
     */
    public static String getFileSuffix(String originalFileName){
        int dot=originalFileName.lastIndexOf('.');
        if((dot>-1)&&(dot<originalFileName.length())){
            return originalFileName.substring(dot);
        }
        return originalFileName;
    }


    public static Map<String,String> uploadFile(MultipartFile file,String path) {
        Map<String,String> map = new HashMap<>();
        String fileName = file.getOriginalFilename();
        //String path = System.getProperty("user.dir") + "/uploadFile";
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String filePath = dest.toString();
        map.put("fileName",fileName);
        map.put("filePath",filePath);
        return map;
    }
}
