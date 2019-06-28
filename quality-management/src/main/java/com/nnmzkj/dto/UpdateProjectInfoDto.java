package com.nnmzkj.dto;

import java.io.Serializable;

public class UpdateProjectInfoDto implements Serializable {
    private static final long serialVersionUID = -5326394950778684731L;

    private Long ProId;

    //项目名称名称
    private String proName;

    //建设办Id
    private Long buildId;

    //建设办名称
    private String buildName;

    //开工状态
    private Byte startStatus;



    public Long getProId() {
        return ProId;
    }

    public void setProId(Long proId) {
        ProId = proId;
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

    public Byte getStartStatus() {
        return startStatus;
    }

    public void setStartStatus(Byte startStatus) {
        this.startStatus = startStatus;
    }


    public UpdateProjectInfoDto() {
    }
}
