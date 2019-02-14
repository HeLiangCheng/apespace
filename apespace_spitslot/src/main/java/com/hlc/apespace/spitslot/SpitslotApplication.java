package com.hlc.apespace.spitslot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
    *@ClassName SpitslotApplication
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 13:57
    *@Version 1.0
**/
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
public class SpitslotApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpitslotApplication.class, args);
    }
}
