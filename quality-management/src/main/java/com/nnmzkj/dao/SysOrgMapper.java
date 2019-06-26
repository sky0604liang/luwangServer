package com.nnmzkj.dao;

import com.nnmzkj.model.SysOrg;

public interface SysOrgMapper {
    int deleteByPrimaryKey(Long orgId);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    SysOrg selectByPrimaryKey(Long orgId);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);
}