package com.nnmzkj.web.controller;


import com.nnmzkj.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/sys/org")
public class SysOrgController {

    @Autowired
    private SysOrgService sysOrgService;

    @GetMapping("/list")
    public ModelAndView getSysOrgSelect(){
        ModelAndView mv = new ModelAndView();
        List<Map<String,Object>> result = sysOrgService.getSysOrgSelect();
        mv.setViewName("/roadNetHtml/add.html");
        mv.addObject("result",result);
        return  mv;
    }

}
