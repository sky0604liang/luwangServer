package com.nnmzkj.common.core;

import java.io.Serializable;
import java.util.List;

public class ResultList implements Serializable {


    private static final long serialVersionUID = -760264276528173495L;

    private long total;

    private List<Object> rows;



    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }



    public ResultList() {
    }

    public ResultList(long total, List<Object> rows) {
        this.total = total;
        this.rows = rows;

    }
}
