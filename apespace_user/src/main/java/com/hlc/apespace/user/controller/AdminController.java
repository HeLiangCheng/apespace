package com.hlc.apespace.user.controller;

import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.common.util.JwtUtil;
import com.hlc.apespace.user.dao.AdminDao;
import com.hlc.apespace.user.entity.Admin;
import com.hlc.apespace.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
    *@ClassName AdminController
    *@Description todo
    *@Author Liang
    *@Date 2019/2/14 10:58
    *@Version 1.0
**/
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/login")
    public Result login(@RequestParam(value = "loginname") String loginname, @RequestParam(value = "password") String password) {
        Admin admin = adminService.findByLoginNameAndPaddword(loginname, password);
        if (admin != null) {
            String jwtStr = jwtUtil.buildJwtStr(admin.getId(), admin.getLoginname(), "admin");
            return new Result(true, StatusCode.OK, jwtStr);
        }
        return new Result(false, StatusCode.LOGIN_ERROR, StatusCode.LOGIN_ERROR_INFO);
    }

}
