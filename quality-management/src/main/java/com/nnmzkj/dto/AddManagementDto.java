package com.nnmzkj.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class AddManagementDto implements Serializable {
    private static final long serialVersionUID = -5594875057514464596L;

    private Long ProId;

    //项目名称名称
    private String proName;

    //建设办名称
    private Long buildId;

    //开工状态
    private Byte startStatus;

    //文件Url
    private String startFile;

    //文件上传
    private MultipartFile blFile;


    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public Byte getStartStatus() {
        return startStatus;
    }

    public void setStartStatus(Byte startStatus) {
        this.startStatus = startStatus;
    }

    public String getStartFile() {
        return startFile;
    }

    public void setStartFile(String startFile) {
        this.startFile = startFile;
    }

    public Long getProId() {
        return ProId;
    }

    public void setProId(Long proId) {
        ProId = proId;
    }

    public MultipartFile getBlFile() {
        return blFile;
    }

    public void setBlFile(MultipartFile blFile) {
        this.blFile = blFile;
    }


}
