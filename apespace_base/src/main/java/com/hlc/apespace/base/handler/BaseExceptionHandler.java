package com.hlc.apespace.base.handler;

import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.common.exception.ApespaceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
    *@ClassName BaseExceptionHandler
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 11:07
    *@Version 1.0
**/
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = ApespaceException.class)
    @ResponseBody
    public Result error(ApespaceException ex) {
        Result result = new Result();
        result.setFlag(false);
        result.setCode(StatusCode.ERROR);
        result.setMessage(StatusCode.ERROR_INFO);
        result.setData(ex.getMessage());
        return result;
    }

}
