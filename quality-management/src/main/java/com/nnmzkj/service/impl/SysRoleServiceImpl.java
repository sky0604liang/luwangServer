package com.nnmzkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnmzkj.dao.SysRoleMapper;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.dto.ObjectManagementListDto;
import com.nnmzkj.model.SysRole;
import com.nnmzkj.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {


    @Autowired
    private SysRoleMapper sysRoleMapper;


    @Override
    public PageInfo selectSysRole(BaseListParameterDto pageMsg) {
        PageHelper.startPage(pageMsg.getPageNumber(),pageMsg.getPageSize());
        List<SysRole> list = sysRoleMapper.selectSysRole(pageMsg.getRoleName());
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
