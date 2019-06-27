package com.nnmzkj.dao;

import com.nnmzkj.model.SysAsset;

public interface SysAssetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAsset record);

    int insertSelective(SysAsset record);

    SysAsset selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAsset record);

    int updateByPrimaryKey(SysAsset record);
}