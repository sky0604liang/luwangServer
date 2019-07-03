package com.nnmzkj.dao;

import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.ObjectManagementListDto;
import com.nnmzkj.dto.UpdateProjectInfoDto;
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
    List<ObjectManagementListDto> selectAll(@Param("buildId") Long buildId);

    int addProject(@Param("param") AddManagementDto addManagementDto);

    int selectObjectInfo(@Param("proName") String proName);

   // QualityProManagement toUpdate(@Param("proId") Long proId);

    void updateProject(@Param("param") UpdateProjectInfoDto updateProjectInfoDto);

    void deleteByLogic(List<Long> list);
}