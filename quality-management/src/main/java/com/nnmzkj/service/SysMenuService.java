package com.nnmzkj.service;

import com.github.pagehelper.PageInfo;

public interface SysMenuService {

    //    查询菜单等级 0 顶级，1 一级菜单，以此类推-
    PageInfo getMenuByParentId(Long  parentId);
}
