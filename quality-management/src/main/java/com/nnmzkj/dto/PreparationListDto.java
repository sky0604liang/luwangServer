package com.nnmzkj.dto;



import java.io.Serializable;



public class PreparationListDto implements Serializable {
    private static final long serialVersionUID = -8447287759527462470L;

    private Long preId;

    private Long proId;

    private String proName;

    private String buildName;

    private Long buildId;

    private Byte preStatus;

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

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
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
}
