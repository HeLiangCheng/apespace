package com.hlc.apespace.friend.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
    *@ClassName UserClient
    *@Description todo
    *@Author Liang
    *@Date 2019/2/15 14:01
    *@Version 1.0
**/
@FeignClient(name = "apespace_user")
public interface UserClient {

    @PostMapping(value = "/incfans/{userid}/{num}")
    public void incFanscount(@PathVariable(value = "userid") String userid, @PathVariable(value = "num") int num);

    @PostMapping(value = "/incfollow/{userid}/{num}")
    public void incFollowcount(@PathVariable(value = "userid") String userid, @PathVariable(value = "num") int num);

}
