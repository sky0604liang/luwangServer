package com.nnmzkj.dao;

import com.nnmzkj.dto.BuildDto;
import com.nnmzkj.model.SysOrg;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOrgMapper {
    int deleteByPrimaryKey(Long orgId);

    int insert(SysOrg record);

    int insertSelective(SysOrg record);

    SysOrg selectByPrimaryKey(Long orgId);

    int updateByPrimaryKeySelective(SysOrg record);

    int updateByPrimaryKey(SysOrg record);

    List<SysOrg> getAllOrg();

    /**
     *
     * @param buildName 机构名称
     * @param buildId  机构id
     */
    void updateOrgNameByOrgId(@Param("buildName") String buildName, @Param("buildId") Long buildId);

    BuildDto getBuildName(@Param("build_id") Long build_id);
}