package com.nnmzkj.web.controller;

import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality")
public class TestController {

    @GetMapping("/test")
    public Result test(){
        String str= "Test";
        if (!StringUtils.isEmpty(str) &&str.equals("Test")){
            throw new QualityManagementException(QualityManagementExceptionCode.EXCEPTION_TEST);
        }
        return ResultGenerator.genSuccessResult(str);
    }
}
