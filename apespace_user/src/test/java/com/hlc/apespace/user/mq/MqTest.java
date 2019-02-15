package com.hlc.apespace.user.mq;

import com.hlc.apespace.user.UserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
    *@ClassName MqTest
    *@Description todo
    *@Author Liang
    *@Date 2019/2/1 9:35
    *@Version 1.0
**/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class MqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSend(){
        rabbitTemplate.convertAndSend("itcast","马上过大年了");
    }

    @Test
    public void testSendFanout(){
        rabbitTemplate.convertAndSend("chuanzhi","","分列模式走起");
    }

    @Test
    public void testSendTopic1() {
        rabbitTemplate.convertAndSend("topictest", "goods.aaa", "主题模式");
    }

    @Test
    public void testSendTopic2() {
        rabbitTemplate.convertAndSend("topictest", "article.content.log", "主题模式");
    }

    @Test
    public void testSendTopic3() {
        rabbitTemplate.convertAndSend("topictest", "goods.log", "主题模式");
    }

}
