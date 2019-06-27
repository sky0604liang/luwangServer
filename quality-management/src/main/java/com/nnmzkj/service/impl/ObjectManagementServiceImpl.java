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
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ObjectManagementServiceImpl implements ObjectManagementService {

    @Autowired
    private QualityProManagementMapper qualityProManagementMapper;


    @Override
    public PageInfo getManagementList(PageMsg pageMsg) {
        PageHelper.startPage(pageMsg.getPage(),pageMsg.getSize());
        List<ObjectManagementListDto> list = qualityProManagementMapper.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int addObject(AddManagementDto addManagementDto) {
        MultipartFile blFile = addManagementDto.getBlFile();
        if (!blFile.isEmpty()){
            String oldFileName = blFile.getOriginalFilename();
            //图片路径
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath()+"static/upload/bl";
            String randomStr = UUID.randomUUID().toString();
            String newFileName = randomStr + oldFileName.substring(oldFileName.lastIndexOf("."));
            File file = new File(path,newFileName);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            try {
                /**
                 * 将接收到的文件传输到给定的目标文件。
                 */
                blFile.transferTo(file);
                System.out.println(path +newFileName);
            } catch (IOException e) {
                throw new QualityManagementException(QualityManagementExceptionCode.FILE_PATH_IS_NULL);
            }
            // blFile.transferTo(file);
        }

        //int status =qualityProManagementMapper.addObject(addManagementDto);
       return 0;
    }


    public boolean isSameFile(String fileName1,String fileName2){
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        try {
            fis1 = new FileInputStream(fileName1);
            fis2 = new FileInputStream(fileName2);

            int len1 = fis1.available();//返回总的字节数
            int len2 = fis2.available();

            if (len1 == len2) {//长度相同，则比较具体内容
                //建立两个字节缓冲区
                byte[] data1 = new byte[len1];
                byte[] data2 = new byte[len2];

                //分别将两个文件的内容读入缓冲区
                fis1.read(data1);
                fis2.read(data2);

                //依次比较文件中的每一个字节
                for (int i=0; i<len1; i++) {
                    //只要有一个字节不同，两个文件就不一样
                    if (data1[i] != data2[i]) {
                        System.out.println("文件内容不一样");
                        return false;
                    }
                }
                System.out.println("两个文件完全相同");
                return true;
            } else {
                //长度不一样，文件肯定不同
                return false;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//关闭文件流，防止内存泄漏
            if (fis1 != null) {
                try {
                    fis1.close();
                } catch (IOException e) {
                    //忽略
                    e.printStackTrace();
                }
            }
            if (fis2 != null) {
                try {
                    fis2.close();
                } catch (IOException e) {
                    //忽略
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

}
