package com.nnmzkj.common.core;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("global-config")
public class FileUploadConfig {
    private String druidName;
    private String druidPwd;
    private String uploadPath;
    private String backupPath;
}
