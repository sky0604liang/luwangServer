package com.nnmzkj.dto;

import com.nnmzkj.common.core.PageMsg;

public class BaseListParameterDto extends PageMsg {
    private static final long serialVersionUID = 5890965823739082620L;

    private Long buildId;

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }
}
