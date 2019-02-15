package com.hlc.apespace.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
    *@ClassName UserApplication
    *@Description todo
    *@Author Liang
    *@Date 2019/1/31 13:48
    *@Version 1.0
**/
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
