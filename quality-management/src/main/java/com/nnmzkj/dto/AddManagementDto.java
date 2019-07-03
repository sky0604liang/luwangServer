package com.nnmzkj.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

public class AddManagementDto implements Serializable {
    private static final long serialVersionUID = -5594875057514464596L;

    private Long ProId;

    //项目名称名称
    private String proName;
    //建设办名称
    private Long buildId;
    //备注
    private String  remark;
    //文件Url
    private String startFile;

    private Date gmtCreate;

    private Date gmtLastModified;

    private String buildName;



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

    public String getRemark() {
        return remark;
    }



    public void setRemark(String remark) {
        this.remark = remark;
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
