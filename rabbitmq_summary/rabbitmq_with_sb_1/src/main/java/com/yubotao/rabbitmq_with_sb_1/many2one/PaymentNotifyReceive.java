package com.yubotao.rabbitmq_with_sb_1.many2one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:55 2018/11/24
 * @Modified By:
 */
@Component
@RabbitListener(queues = "notify.payment")
public class PaymentNotifyReceive {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void receive(String msg) {
        logger.info("notify.payment receive message: "+msg);
    }
}
