package com.nnmzkj.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class  TemplateTestController {


    @GetMapping("/index")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("test","admin");
        mv.setViewName("/user/index.html");
        return mv;
    }


}
