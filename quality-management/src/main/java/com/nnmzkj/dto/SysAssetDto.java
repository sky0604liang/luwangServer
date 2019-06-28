package com.nnmzkj.dto;

import java.io.Serializable;

public class SysAssetDto implements Serializable {
    private static final long serialVersionUID = 4086773904285636054L;

    private Long fileId;

    private String fileName;

    private Long fileSize;

    private String fileUrl;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
