package com.hlc.apespace.faqs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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
public class FaqsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FaqsApplication.class);
    }

}
