package com.nnmzkj.dao;

import com.nnmzkj.dto.QualityProApprovalListDto;
import com.nnmzkj.model.QualityProApproval;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QualityProApprovalMapper {
    int deleteByPrimaryKey(Long approvalId);

    int insert(QualityProApproval record);

    int insertSelective(QualityProApproval record);

    QualityProApproval selectByPrimaryKey(Long approvalId);

    int updateByPrimaryKeySelective(QualityProApproval record);

    int updateByPrimaryKey(QualityProApproval record);

    List<QualityProApprovalListDto> list(@Param("buildId") Long buildId);

    int getAllList(@Param("proId") Long proId,@Param("status") Integer status);
}