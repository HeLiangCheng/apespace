package com.hlc.apespace.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hlc.apespace.common.constant.StatusCode;

import java.io.Serializable;

/**
    *@ClassName Result
    *@Description todo
    *@Author Liang
    *@Date 2019/1/28 13:21
    *@Version 1.0
**/
public class Result {

    /**
     * 是否成功
     */
    private boolean flag;
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;

    public Result(){
    }

    public Result(boolean flag,Integer code,String message,Object data) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(boolean flag,Integer code,String message) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok() {
        return new Result(true, StatusCode.OK, StatusCode.OK_INFO);
    }

    public static Result error() {
        return new Result(false, StatusCode.ERROR, StatusCode.ERROR_INFO);
    }

}
