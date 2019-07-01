package com.nnmzkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@MapperScan(basePackages = "com.nnmzkj.dao")
public class QualityManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QualityManagementApplication.class,args);
    }
}