package com.nnmzkj.web.controller;


import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.Test;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/menu")
public class SysMenuController {


    @Autowired
    private SysMenuService sysMenuService;


    @GetMapping("/index")
    public String index() {
        return "/roadNetHtml/index.html";
    }

    @GetMapping("/sysList")
    public String sysList() {
        return "/roadNetHtml/page/admin/menu.html";
    }

    //菜单管理列表
    @GetMapping("/list")
    @ResponseBody
    public Test getManagementList(BaseListParameterDto pageMsg) {
        Test test = new Test();
        if (StringUtils.isEmpty(pageMsg)) {
            throw new QualityManagementException(QualityManagementExceptionCode.PAGE_IS_NULL);
        }
        PageInfo pageInfo = sysMenuService.getMenuByParentId(pageMsg.getBuildId());
        long total = pageInfo.getTotal();
        test.setTotal(total);
        test.setRows(pageInfo.getList());
        return test;
    }
}