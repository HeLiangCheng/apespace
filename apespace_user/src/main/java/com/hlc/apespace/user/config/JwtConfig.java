package com.hlc.apespace.user.config;

import com.hlc.apespace.common.util.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
    *@ClassName JwtConfig
    *@Description todo
    *@Author Liang
    *@Date 2019/2/14 13:40
    *@Version 1.0
**/
@Configuration
public class JwtConfig {

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil();
    }

}
