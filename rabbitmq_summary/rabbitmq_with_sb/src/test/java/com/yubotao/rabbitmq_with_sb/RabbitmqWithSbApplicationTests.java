package com.yubotao.rabbitmq_with_sb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqWithSbApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendToRemoteServer(){
        // 将对象序列化之后发送到rabbitmq中指定的交换器绑定的队列中去
        rabbitTemplate.convertAndSend("test.exchange", "test2.queue", "测试发送到交换器绑定的某队列中的消息");
    }
}
