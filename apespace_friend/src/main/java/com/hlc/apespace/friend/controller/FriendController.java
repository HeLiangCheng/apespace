package com.hlc.apespace.friend.controller;

import com.hlc.apespace.common.constant.StatusCode;
import com.hlc.apespace.common.entity.Result;
import com.hlc.apespace.friend.client.UserClient;
import com.hlc.apespace.friend.service.FriendService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
    *@ClassName FriendController
    *@Description todo
    *@Author Liang
    *@Date 2019/2/15 10:33
    *@Version 1.0
**/
@RestController
@RequestMapping("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserClient userClient;

    /**
     * 添加朋友关系
     * @param friendid  好友id
     * @param type  类型 喜欢：1  不喜欢：2
     * @return
     */
    @PostMapping("/like/{friendid}/{type}")
    public Result addFriend(@PathVariable(name = "friendid") String friendid, @PathVariable(name="type") String type) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESS_ERROR, StatusCode.ACCESS_ERROR_INFO);
        }
        if ("1".equals(type)) {
            if (friendService.addFriend(claims.getId(), friendid) > 0) {
                userClient.incFanscount(claims.getId(),1);
                userClient.incFollowcount(friendid,1);
                return new Result(true, StatusCode.OK, StatusCode.OK_INFO);
            }
        } else {
            //不喜欢
            friendService.addNoFriend(claims.getId(),friendid);
        }
        return Result.ok();
    }

    @DeleteMapping("/{friendid}")
    public Result remove(@PathVariable(name = "friendid") String friendid) {
        Claims claims = (Claims) request.getAttribute("user_claims");
        if (claims == null) {
            return new Result(false, StatusCode.ACCESS_ERROR, StatusCode.ACCESS_ERROR_INFO);
        }
        friendService.deleteFriend(claims.getId(), friendid);
        userClient.incFanscount(claims.getId(),-1);
        userClient.incFollowcount(friendid,-1);
        return Result.ok();
    }

}
