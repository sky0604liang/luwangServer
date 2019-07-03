package com.nnmzkj.dto;

import java.io.Serializable;

public class UpdateProjectInfoDto implements Serializable {
    private static final long serialVersionUID = -5326394950778684731L;

    private Long ProId;


    private String remark;

    private String startFile;



    public Long getProId() {
        return ProId;
    }

    public void setProId(Long proId) {
        ProId = proId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStartFile() {
        return startFile;
    }

    public void setStartFile(String startFile) {
        this.startFile = startFile;
    }

    public UpdateProjectInfoDto() {
    }
}
