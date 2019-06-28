package com.nnmzkj.dto;

import java.io.Serializable;

public class QualityProApprovalListDto implements Serializable {
    private static final long serialVersionUID = -3552633821525191188L;

    private  Long proId;

    private String proName;

    private Long buildId;

    private String buildName;

    //进度
    private String progress;

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
        this.proName = proName;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}
