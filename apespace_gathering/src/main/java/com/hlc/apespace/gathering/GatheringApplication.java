package com.hlc.apespace.gathering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
    *@ClassName GatheringApplication
    *@Description todo
    *@Author Liang
    *@Date 2019/1/30 11:17
    *@Version 1.0
**/
@SpringBootApplication
@EnableAutoConfiguration
@EnableCaching
@EnableEurekaClient
public class GatheringApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatheringApplication.class);
    }

}
