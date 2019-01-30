package com.hlc.apespace.common.entity;

import java.io.Serializable;
import java.util.List;

/**
    *@ClassName ResultPage
    *@Description todo
    *@Author Liang
    *@Date 2019/1/28 13:27
    *@Version 1.0
**/
public class ResultPage<T> implements Serializable {

    private Integer code;
    private String message;
    private Long total;
    private List<T> rows;
    private Integer pageSize;
    private Integer pageIndex;

    public ResultPage(){}

    public ResultPage(Integer code,String message,Long total,List<T> rows,Integer pageSize,Integer pageIndex) {
        super();
        this.code = code;
        this.message = message;
        this.total = total;
        this.rows = rows;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }
}
