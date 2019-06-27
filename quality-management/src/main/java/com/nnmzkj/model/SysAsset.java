package com.nnmzkj.model;

import java.util.Date;

public class SysAsset {
    private Long id;

    private Long fileSize;

    private String fileUrl;

    private String fileName;

    private Date createTime;

    private Long qualityProId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getQualityProId() {
        return qualityProId;
    }

    public void setQualityProId(Long qualityProId) {
        this.qualityProId = qualityProId;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public SysAsset() {
    }

    public SysAsset(String fileUrl, String fileName, Long fileSize,Date createTime, Long qualityProId) {
        this.fileUrl = fileUrl;
        this.fileName = fileName;
        this.fileSize =fileSize;
        this.createTime = createTime;
        this.qualityProId = qualityProId;
    }
}