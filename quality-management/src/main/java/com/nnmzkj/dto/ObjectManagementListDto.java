package com.nnmzkj.dto;





import java.io.Serializable;
import java.util.Date;

public class ObjectManagementListDto implements Serializable {

    private static final long serialVersionUID = 6855690377354751473L;
    //id
    private Long proId;

    //项目名称名称
    private String proName;

    //建设办名称
    private String buildName;


    //开工状态
    private Byte startStatus;

    private Date gmtCreate;

    private String remark;

    //文件Url
    private String startFile;


    public ObjectManagementListDto(Long proId) {
        this.proId = proId;
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

  /*  public BuildDto getBuildDto() {
        return buildDto;
    }

    public void setBuildDto(BuildDto buildDto) {
        this.buildDto = buildDto;
    }*/

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

    public ObjectManagementListDto() {
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
