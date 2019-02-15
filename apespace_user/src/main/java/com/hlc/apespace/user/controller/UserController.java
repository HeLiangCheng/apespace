package com.hlc.apespace.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.common.util.JwtUtil;
import com.hlc.apespace.user.entity.User;
import com.hlc.apespace.user.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.border.EtchedBorder;
import java.util.HashMap;

/**
    *@ClassName UserController
    *@Description todo
    *@Author Liang
    *@Date 2019/2/1 10:29
    *@Version 1.0
**/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(value = "/sendsms/{mobile}")
    public Result sendsms(@PathVariable(name = "mobile") String mobile) {
        userService.sendSms(mobile);
        return Result.ok();
    }

    @PostMapping(value = "/login/mobile")
    public Result loginByMobile(@RequestParam(value = "mobile") String mobile, @RequestParam(value = "password") String password) {
        User user = userService.findByMobileAndPassword(mobile, password);
        if (user != null) {
            String token = jwtUtil.buildJwtStr(user.getId(), user.getNickname(), "user");
            HashMap map = new HashMap();
            map.put("token", token);
            map.put("name", user.getNickname());
            map.put("avatar", user.getAvatar());
            return new Result(true, StatusCode.OK, JSON.toJSONString(map));
        }
        return new Result(false, StatusCode.LOGIN_ERROR, StatusCode.LOGIN_ERROR_INFO);
    }

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id") String id, HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("admin_claims");
        if (claims != null) {
            return new Result(true, StatusCode.ACCESS_ERROR, StatusCode.ACCESS_ERROR_INFO);
        }
        userService.deleteUserById(id);
        return new Result(true, StatusCode.OK, StatusCode.OK_INFO);
    }

    @PostMapping(value = "/incfans/{userid}/{num}")
    public void incFanscount(@PathVariable(value = "userid") String userid,@PathVariable(value = "num") int num) {
        userService.incFanscount(userid, num);
    }

    @PostMapping(value = "/incfollow/{userid}/{num}")
    public void incFollowcount(@PathVariable(value = "userid") String userid,@PathVariable(value = "num") int num) {
        userService.incFollowcount(userid, num);
    }

}
