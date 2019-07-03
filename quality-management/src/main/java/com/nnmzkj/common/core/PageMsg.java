package com.nnmzkj.common.core;

import java.io.Serializable;


public class PageMsg implements Serializable {
	
	private static final long serialVersionUID = -7986811158226754922L;
	
	/**
     * 页码
     */

    private int pageNumber ;
	
    /**
     * 每页条数
     */
    private int pageSize ;

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

	public PageMsg(int pageNumber, int pageSize) {
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}

	public PageMsg() {
		super();
	}
     
}
