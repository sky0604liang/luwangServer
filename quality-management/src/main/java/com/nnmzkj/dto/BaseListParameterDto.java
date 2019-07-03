package com.nnmzkj.dto;


import lombok.Data;

@Data
public class BaseListParameterDto  {
    private static final long serialVersionUID = 5890965823739082620L;

    private Long buildId;

    private String  roleName;

    private int pageNumber = 1;

    /**
     * 每页条数
     */
    private int pageSize = 15;

}
