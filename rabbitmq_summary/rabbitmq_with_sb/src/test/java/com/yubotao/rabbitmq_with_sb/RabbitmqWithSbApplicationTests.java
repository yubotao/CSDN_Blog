package com.yubotao.rabbitmq_with_sb;

import com.yubotao.rabbitmq_with_sb.producer.MsgProducer;
import com.yubotao.rabbitmq_with_sb.producer.PublishService;
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

    @Autowired
    PublishService publishService;

    private static String exChange = "my-mq-exchange_A";

    @Test
    public void contextLoads() {
    }

    @Test
    public void sendToRemoteServer(){
        // 将对象序列化之后发送到rabbitmq中指定的交换器绑定的队列中去
        rabbitTemplate.convertAndSend("test.exchange", "test2.queue", "测试发送到交换器绑定的某队列中的消息");
    }

    @Test
    public void test1() throws InterruptedException{
        String message = "currentTime:" + System.currentTimeMillis();
        System.out.println("test1---message:"+message);
        //exchange,queue 都正确,confirm被回调, ack=true
        publishService.send(exChange, "spring-boot-routingKey_B", message);
        Thread.sleep(1000);
    }

    @Test
    public void test2() throws InterruptedException{
        String message = "currentTime:"+System.currentTimeMillis();
        System.out.println("test2---message:"+message);
        //exchange 错误,queue 正确,confirm被回调, ack=false
        publishService.send(exChange+"NO","spring-boot-routingKey_B",message);
        Thread.sleep(1000);
    }

    @Test
    public void test3() throws InterruptedException{
        String message = "currentTime:"+System.currentTimeMillis();
        System.out.println("test3---message:"+message);
        //exchange 正确,queue 错误 ,confirm被回调, ack=true; return被回调 replyText:NO_ROUTE
        publishService.send(exChange,"",message);
//        Thread.sleep(1000);
    }

    @Test
    public void test4() throws InterruptedException{
        String message = "currentTime:"+System.currentTimeMillis();
        System.out.println("test4---message:"+message);
        //exchange 错误,queue 错误,confirm被回调, ack=false
        publishService.send(exChange+"NO","spring-boot-routingKey_B",message);
        Thread.sleep(1000);
    }
}
