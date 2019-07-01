package com.nnmzkj.dao;

import com.nnmzkj.model.SysMenu;
import com.nnmzkj.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);


    int checkAdmin(@Param("userName")String username);

    SysUser getAdminByUserName(@Param("userName")String userName);

    List<SysMenu> getPermissionList(Long userId);

    Long getUserInfo(@Param("userName") String userName);
}