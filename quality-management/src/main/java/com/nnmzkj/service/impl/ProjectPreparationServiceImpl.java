package com.nnmzkj.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nnmzkj.dao.QualityPreparationMapper;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.dto.PreparationListDto;
import com.nnmzkj.model.QualityPreparation;
import com.nnmzkj.service.ProjectPreparationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectPreparationServiceImpl implements ProjectPreparationService {

   @Autowired
   private QualityPreparationMapper qualityPreparationMapper;

    @Override
    public PageInfo list(BaseListParameterDto baseListParameterDto) {
        PageHelper.startPage(baseListParameterDto.getPage(),baseListParameterDto.getSize());
        List<PreparationListDto> list = qualityPreparationMapper.list(baseListParameterDto.getBuildId());
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public void addPreparationInfo(QualityPreparation qualityPreparation) {
        qualityPreparation.setGmtCreate(new Date());
        qualityPreparation.setGmtLastModified(new Date());
        qualityPreparationMapper.insertSelective(qualityPreparation);
    }

    @Override
    public List<QualityPreparation> toAddPreparationInfo(Long proId) {
        return qualityPreparationMapper.selectPreparationInfoByProId(proId);
    }

    @Override
    public void updatePreparationInfo(QualityPreparation qualityPreparation) {
        qualityPreparation.setGmtLastModified(new Date());
        qualityPreparationMapper.updateByPrimaryKeySelective(qualityPreparation);
    }
}
