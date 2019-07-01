package com.nnmzkj.model;

import java.io.Serializable;
import java.util.Date;

public class SystemLog implements Serializable {
    private static final long serialVersionUID = -8988672932052190440L;
    private Long id;

    private Long adminId;

    private String adminName;

    private String path;

    private String page;

    private String ip;

    private Date addTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public SystemLog() {
    }

    public SystemLog(Long adminId, String adminName, String path, String page, String ip, Date addTime) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.path = path;
        this.page = page;
        this.ip = ip;
        this.addTime = addTime;
    }
}