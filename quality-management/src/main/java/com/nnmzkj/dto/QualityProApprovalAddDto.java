package com.nnmzkj.dto;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class QualityProApprovalAddDto implements Serializable {


    private static final long serialVersionUID = -7602033118609720267L;
    private MultipartFile blFile;

    public MultipartFile getBlFile() {
        return blFile;
    }

    public void setBlFile(MultipartFile blFile) {
        this.blFile = blFile;
    }
}
