package com.nnmzkj.service;


import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.dto.AddManagementDto;
import com.nnmzkj.dto.UpdateProjectInfoDto;

import java.util.Map;

public interface ProjectManagementService {
    /**
     * 获取项目管理列表
     * @param pageMsg
     * @return
     */
    PageInfo getManagementList(PageMsg pageMsg);

    /**
     * 新增项目
     * @param addManagementDto
     * @return
     */
    void addProject(AddManagementDto addManagementDto);

    Map<String,Object> toUpdate(Long proId);

    void updateProject(UpdateProjectInfoDto updateProjectInfoDto);
}
