package com.nnmzkj.dao;

import com.nnmzkj.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Long menuId);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Long menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> getPermissionList(Long userId);

//    查询菜单等级 0 顶级，1 一级菜单，以此类推-
    List<SysMenu> getMenuByParentId(@Param("parentId")Long parentId);

}