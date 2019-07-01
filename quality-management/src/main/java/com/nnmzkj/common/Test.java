package com.nnmzkj.common;

import com.nnmzkj.dto.QualityProApprovalListDto;

import java.io.Serializable;
import java.util.List;

public class Test implements Serializable {
    private static final long serialVersionUID = -3941835742723951236L;

    private long total;

    private List<QualityProApprovalListDto> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<QualityProApprovalListDto> getRows() {
        return rows;
    }

    public void setRows(List<QualityProApprovalListDto> rows) {
        this.rows = rows;
    }
}
