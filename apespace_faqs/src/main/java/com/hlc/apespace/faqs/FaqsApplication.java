package com.hlc.apespace.faqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
    *@ClassName FaqsApplication
    *@Description todo
    *@Author Liang
    *@Date 2019/1/29 15:54
    *@Version 1.0
**/
@SpringBootApplication
@EnableAutoConfiguration
@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
public class FaqsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaqsApplication.class);
    }

}
