package com.yubotao.rabbitmq_with_sb.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 17:08 2019/7/23
 * @Modified By:
 */
@Service("publishService")
public class PublishService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
