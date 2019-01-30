package com.hlc.apespace.common.constant;
/**
    *@ClassName StatusCode
    *@Description 状态码实体类
    *@Author Liang
    *@Date 2019/1/28 13:33
    *@Version 1.0
**/

public class StatusCode {

    /**
     * 成功
     */
    public static final int OK = 20000;
    public static final String OK_INFO = "执行成功";
    /**
     * 失败
     */
    public static final int ERROR = 10000;
    public static final String ERROR_INFO = "执行失败";
    /**
     * 用户名或密码错误
     */
    public static final int LOGIN_ERROR = 10001;
    public static final String LOGIN_ERROR_INFO = "用户名或密码错误";
    /**
     * 权限不足
     */
    public static final int ACCESS_ERROR = 10002;
    public static final String ACCESS_ERROR_INFO = "权限不足";
    /**
     * 远程调用失败
     */
    public static final int REMOTE_ERROR = 10003;
    public static final String REMOTE_ERROR_INFO = "远程调用失败";
    /**
     * 重复操作
     */
    public static final int REP_ERROR = 10004;
    public static final String REP_ERROR_INFO = "重复操作";
}
