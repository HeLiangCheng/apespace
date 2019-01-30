package com.hlc.apespace.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
    *@ClassName BaseApplication
    *@Description todo
    *@Author Liang
    *@Date 2019/1/28 13:56
    *@Version 1.0
**/
@SpringBootApplication
@EnableAutoConfiguration
public class BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class);
    }

}
