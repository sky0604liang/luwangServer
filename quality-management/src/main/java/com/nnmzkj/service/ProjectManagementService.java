package com.nnmzkj.service;


import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.dto.UpdateProjectInfoDto;
import com.nnmzkj.model.QualityProManagement;

import java.util.List;
import java.util.Map;

public interface ProjectManagementService {
    /**
     * 获取项目管理列表
     * @param pageMsg
     * @return
     */
    PageInfo getManagementList(BaseListParameterDto pageMsg);

    /**
     * 新增项目
     * @param addManagementDto
     * @return
     */
    void addProject(AddManagementDto addManagementDto);

    QualityProManagement toUpdate(Long proId);

    void updateProject(UpdateProjectInfoDto updateProjectInfoDto);

    void deleteByLogic(List<Long> list);

    void deleteAsset(Long proId);
}
