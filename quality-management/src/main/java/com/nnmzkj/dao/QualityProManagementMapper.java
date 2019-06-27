package com.nnmzkj.dao;

import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.ObjectManagementListDto;
import com.nnmzkj.model.QualityProManagement;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QualityProManagementMapper {
    int deleteByPrimaryKey(Long proId);

    int insert(QualityProManagement record);

    int insertSelective(QualityProManagement record);

    QualityProManagement selectByPrimaryKey(Long proId);

    int updateByPrimaryKeySelective(QualityProManagement record);

    int updateByPrimaryKey(QualityProManagement record);

    /**
     * 项目管理列表
     * @return
     */
    List<ObjectManagementListDto> selectAll();

    int addProject(AddManagementDto addManagementDto);

    int selectObjectInfo(@Param("proName") String proName);
}