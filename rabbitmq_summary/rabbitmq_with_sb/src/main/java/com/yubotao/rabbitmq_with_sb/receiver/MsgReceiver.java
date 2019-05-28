package com.yubotao.rabbitmq_with_sb.receiver;

import com.yubotao.rabbitmq_with_sb.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:26 2018/11/22
 * @Modified By:
 */
@Component
@RabbitListener(queues = {RabbitConfig.QUEUE_A, RabbitConfig.QUEUE_B, RabbitConfig.QUEUE_C})

public class MsgReceiver {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content){
        logger.info("接收处理队列A或B或C当中的消息： " + content);
    }

}
