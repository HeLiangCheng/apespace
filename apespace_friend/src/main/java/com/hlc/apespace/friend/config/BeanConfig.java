package com.hlc.apespace.friend.config;

import com.hlc.apespace.common.util.IdWorker;
import com.hlc.apespace.common.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
    *@ClassName BeanConfig
    *@Description todo
    *@Author Liang
    *@Date 2019/2/15 9:01
    *@Version 1.0
**/
@Configuration
public class BeanConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

}
