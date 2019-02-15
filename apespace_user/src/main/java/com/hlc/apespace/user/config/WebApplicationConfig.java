package com.hlc.apespace.user.config;

import com.hlc.apespace.user.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
    *@ClassName WebApplicationConfig
    *@Description todo
    *@Author Liang
    *@Date 2019/2/14 13:48
    *@Version 1.0
**/

public class WebApplicationConfig extends WebMvcConfigurationSupport {

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtFilter)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/login");
    }
}
