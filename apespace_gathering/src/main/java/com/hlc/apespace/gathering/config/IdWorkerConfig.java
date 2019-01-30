package com.hlc.apespace.gathering.config;

import com.hlc.apespace.common.util.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
    *@ClassName IdWorker
    *@Description todo
    *@Author Liang
    *@Date 2019/1/28 13:59
    *@Version 1.0
**/
@Configuration
public class IdWorkerConfig {

    @Bean
    public IdWorker idWorker() {
        return new IdWorker(31, 31);
    }

}
