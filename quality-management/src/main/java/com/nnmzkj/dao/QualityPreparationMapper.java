package com.nnmzkj.dao;

import com.nnmzkj.dto.PreparationListDto;
import com.nnmzkj.model.QualityPreparation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QualityPreparationMapper {
    int deleteByPrimaryKey(Long preId);

    int insert(QualityPreparation record);

    int insertSelective(QualityPreparation record);

    QualityPreparation selectByPrimaryKey(Long preId);

    int updateByPrimaryKeySelective(QualityPreparation record);

    int updateByPrimaryKey(QualityPreparation record);

    List<PreparationListDto> list(@Param("buildId") Long orgId);
}