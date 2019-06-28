package com.nnmzkj.service;

import com.github.pagehelper.PageInfo;
import com.nnmzkj.dto.BaseListParameterDto;

public interface ProjectPreparationService {
    PageInfo list(BaseListParameterDto baseListParameterDto);
}
