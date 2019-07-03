package com.nnmzkj.dao;

import com.nnmzkj.model.SysAsset;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAssetMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysAsset record);

    int insertSelective(SysAsset record);

    SysAsset selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysAsset record);

    int updateByPrimaryKey(SysAsset record);

    List<SysAsset> getProjectAssetByProId(@Param("proId") Long proId);


    void batchDelete(List<Long> list);

    void deleteByProId(@Param("proId") Long proId);
}