package com.nnmzkj.dto;

import com.nnmzkj.common.core.PageMsg;

public class BaseListParameterDto extends PageMsg {
    private static final long serialVersionUID = 5890965823739082620L;

    private Long builId;

    public Long getBuilId() {
        return builId;
    }

    public void setBuilId(Long builId) {
        this.builId = builId;
    }
}
