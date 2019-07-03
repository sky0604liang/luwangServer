package com.nnmzkj.model;

import java.util.Date;

public class QualityProManagement {
    private Long proId;

    private String proName;

    private Long buildId;

    private Byte preStatus;

    private Byte startStatus;

    private String startFile;

    private String remark;

    private Date gmtCreate;

    private String buildName;

    private Date gmtLastModified;

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public Byte getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Byte preStatus) {
        this.preStatus = preStatus;
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
        this.startFile = startFile == null ? null : startFile.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtLastModified() {
        return gmtLastModified;
    }

    public void setGmtLastModified(Date gmtLastModified) {
        this.gmtLastModified = gmtLastModified;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }
}