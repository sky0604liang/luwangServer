package com.nnmzkj.web.controller;

import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.Test;
import com.nnmzkj.common.exception.QualityManagementException;
import com.nnmzkj.common.exception.QualityManagementExceptionCode;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/sys/role")
public class SysRoleController {


    @Autowired
    private SysRoleService sysRoleService;


    @GetMapping("/index")
    public String index() {
        System.out.println("1111");
        return "/roadNetHtml/index.html";
    }

    @GetMapping("/sysList")
    public String sysList() {
        return "/roadNetHtml/page/admin/role.html";
    }

    //项目管理列表
    @GetMapping("/list")
    @ResponseBody
    public Test getManagementList(BaseListParameterDto pageMsg){
        Test test = new Test();
        if (StringUtils.isEmpty(pageMsg)){
            throw new QualityManagementException(QualityManagementExceptionCode.PAGE_IS_NULL);
        }
        PageInfo pageInfo = sysRoleService.selectSysRole(pageMsg);
        long total = pageInfo.getTotal();
        test.setTotal(total);
        test.setRows(pageInfo.getList());
        return test;
    }

}
