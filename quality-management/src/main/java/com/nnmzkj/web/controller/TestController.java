package com.nnmzkj.web.controller;

import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quality")
public class TestController {

    @GetMapping("/test")
    public Result test(){
        String str= "Test";
        return ResultGenerator.genSuccessResult(str);
    }
}
