package com.hlc.apespace.user.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
    *@ClassName Customer1
    *@Description todo
    *@Author Liang
    *@Date 2019/2/1 9:50
    *@Version 1.0
**/
@Component
@RabbitListener(queues = "itcast")
public class Customer1 {

    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("itcast接收到信息：" + message);
    }

}
