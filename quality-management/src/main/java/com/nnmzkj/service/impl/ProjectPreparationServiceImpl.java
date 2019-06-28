package com.nnmzkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnmzkj.dao.QualityPreparationMapper;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.dto.PreparationListDto;
import com.nnmzkj.service.ProjectPreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectPreparationServiceImpl implements ProjectPreparationService {

   @Autowired
   private QualityPreparationMapper qualityPreparationMapper;

    @Override
    public PageInfo list(BaseListParameterDto baseListParameterDto) {
        PageHelper.startPage(baseListParameterDto.getPage(),baseListParameterDto.getSize());
        List<PreparationListDto> list = qualityPreparationMapper.list(baseListParameterDto.getBuilId());
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }
}
