package com.nnmzkj.service;

import com.github.pagehelper.PageInfo;
import com.nnmzkj.dto.BaseListParameterDto;
import com.nnmzkj.model.QualityProApproval;

public interface QualityProApprovalService {

    PageInfo list(BaseListParameterDto baseListParameterDto);

    void addProApproval(QualityProApproval qualityProApproval);
}
