package com.yubotao.rabbitmq_with_sb.receiver.ack;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 17:03 2019/7/23
 * @Modified By:
 */
public class ReturnCallBackListener implements RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息主体 message："+message);
        System.out.println("应答码 replyCode: ："+replyCode);
        System.out.println("原因描述 replyText："+replyText);
        System.out.println("交换机 exchange："+exchange);
        System.out.println("消息使用的路由键 routingKey："+routingKey);
    }
}
