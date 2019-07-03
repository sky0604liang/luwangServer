package com.nnmzkj.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project/build")
public class projectBuildController {


    @GetMapping("/index")
    public String index() {
        return "/roadNetHtml/index.html";
    }

    @GetMapping("/list")
    public String toList() {
        return "/roadNetHtml/page/projectBuild/buildList.html";
    }

    @GetMapping("/tolist")
    public String tolist() {
        return "/roadNetHtml/page/projectBuild/buildList.html";
    }
}