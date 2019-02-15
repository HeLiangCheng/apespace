package com.hlc.apespace.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
    *@ClassName FriendApplication
    *@Description todo
    *@Author Liang
    *@Date 2019/2/15 8:51
    *@Version 1.0
**/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FriendApplication {
    public static void main(String[] args) {
        SpringApplication.run(FriendApplication.class, args);
    }
}
