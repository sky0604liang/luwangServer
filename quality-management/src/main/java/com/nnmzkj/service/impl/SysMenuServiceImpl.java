package com.nnmzkj.service.impl;

import com.github.pagehelper.PageInfo;
import com.nnmzkj.dao.SysMenuMapper;
import com.nnmzkj.model.SysMenu;
import com.nnmzkj.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl  implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;


    @Override
    public PageInfo getMenuByParentId(Long parentId) {
        List<SysMenu> list = sysMenuMapper.getMenuByParentId(parentId);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
