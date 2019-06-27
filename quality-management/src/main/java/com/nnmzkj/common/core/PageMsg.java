package com.nnmzkj.common.core;

import java.io.Serializable;


public class PageMsg implements Serializable {
	
	private static final long serialVersionUID = -7986811158226754922L;
	
	/**
     * 页码
     */

    private int page = 1;
	
    /**
     * 每页条数
     */
    private int size = 10;
    
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public PageMsg(int page, int size) {
		super();
		this.page = page;
		this.size = size;
	}
	
	public PageMsg() {
		super();
	}
     
}
