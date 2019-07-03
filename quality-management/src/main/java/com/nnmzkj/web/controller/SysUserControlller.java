package com.nnmzkj.web.controller;


import org.springframework.web.bind.annotation.GetMapping;

public class SysUserControlller {

    @GetMapping("/index")
    public String index() {
        return "/roadNetHtml/index.html";
    }

    @GetMapping("/sysList")
    public String toList() {
        return "/admin/userList.html";
    }

}
