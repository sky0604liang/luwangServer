package com.nnmzkj.model;

import java.io.Serializable;
import java.util.Date;

public class QualityPreparation implements Serializable {
    private static final long serialVersionUID = -5350574567843150457L;
    private Long preId;

    private Long proId;

    private String preContent;

    private String preFile;

    private String remark;

    private Date gmtCreate;

    private Date gmtLastModified;

    public Long getPreId() {
        return preId;
    }

    public void setPreId(Long preId) {
        this.preId = preId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getPreContent() {
        return preContent;
    }

    public void setPreContent(String preContent) {
        this.preContent = preContent == null ? null : preContent.trim();
    }

    public String getPreFile() {
        return preFile;
    }

    public void setPreFile(String preFile) {
        this.preFile = preFile == null ? null : preFile.trim();
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
}