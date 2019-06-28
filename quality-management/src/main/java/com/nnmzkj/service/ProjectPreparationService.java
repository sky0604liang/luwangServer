package com.nnmzkj.service;

import com.github.pagehelper.PageInfo;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.model.QualityPreparation;

import java.util.List;

public interface ProjectPreparationService {
    PageInfo list(BaseListParameterDto baseListParameterDto);

    void addPreparationInfo(QualityPreparation qualityPreparation);

    List<QualityPreparation> toAddPreparationInfo(Long proId);

    void updatePreparationInfo(QualityPreparation qualityPreparation);
}
