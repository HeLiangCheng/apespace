package com.hlc.apespace.user.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
    *@ClassName Customer2
    *@Description todo
    *@Author Liang
    *@Date 2019/2/1 10:01
    *@Version 1.0
**/
@Component
@RabbitListener(queues = "kudingyu")
public class Customer3 {

    @RabbitHandler
    public void showMessage(String message) {
        System.out.println("kudingyu接受到消息" + message);
    }

}
