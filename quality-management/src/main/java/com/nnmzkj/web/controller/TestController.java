package com.nnmzkj.web.controller;

import com.nnmzkj.common.core.Result;
import com.nnmzkj.common.core.ResultGenerator;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/quality")
public class TestController {

    @GetMapping("/test")
    @ResponseBody
    public Result test(){
        String str= "Test";
        if (!StringUtils.isEmpty(str) &&str.equals("Test")){
            throw new QualityManagementException(QualityManagementExceptionCode.EXCEPTION_TEST);
        }
        return ResultGenerator.genSuccessResult(str);
    }

    @GetMapping("/test2")
    public ModelAndView test2(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("test","admin");
        mv.setViewName("/test/index.html");
        return mv;
    }
}
