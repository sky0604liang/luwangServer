package com.nnmzkj.model;

import com.nnmzkj.dto.QualityProApprovalAddDto;

import java.io.Serializable;
import java.util.Date;

public class QualityProApproval extends QualityProApprovalAddDto implements Serializable {
    private static final long serialVersionUID = -1588700309193861681L;
    private Long approvalId;

    private Long proId;

    private String approvalContent;

    private String approvalFile;

    private Date applicationTime;

    private Date replyTime;

    private Byte approvalStatus;

    private String remark;

    private Date gmtCreate;

    private Date gmtLastModified;

    public Long getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getApprovalContent() {
        return approvalContent;
    }

    public void setApprovalContent(String approvalContent) {
        this.approvalContent = approvalContent == null ? null : approvalContent.trim();
    }

    public String getApprovalFile() {
        return approvalFile;
    }

    public void setApprovalFile(String approvalFile) {
        this.approvalFile = approvalFile == null ? null : approvalFile.trim();
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Byte getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Byte approvalStatus) {
        this.approvalStatus = approvalStatus;
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