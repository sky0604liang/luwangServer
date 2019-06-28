package com.nnmzkj.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TemplateTestController {


    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("test","admin");
        mv.setViewName("/index.html");
        return mv;
    }


}
