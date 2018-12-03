package com.yubotao.rabbitmq_with_sb_1.many2one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:57 2018/11/24
 * @Modified By:
 */
@Component
public class PaymentNotifySender {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender(String msg){
        logger.info("notify.payment send message: "+msg);
        rabbitTemplate.convertAndSend("notify.payment", msg);
    }
}
