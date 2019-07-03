package com.nnmzkj.dto;


public class BaseListParameterDto  {
    private static final long serialVersionUID = 5890965823739082620L;

    private Long buildId;

    private int pageNumber = 1;

    /**
     * 每页条数
     */
    private int pageSize = 5;


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Long getBuildId() {
        return buildId;
    }

    public void setBuildId(Long buildId) {
        this.buildId = buildId;
    }
}
