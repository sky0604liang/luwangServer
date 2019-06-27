package com.nnmzkj.service;


import com.github.pagehelper.PageInfo;
import com.nnmzkj.common.core.PageMsg;
import com.nnmzkj.dto.AddManagementDto;

public interface ObjectManagementService {
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
}
