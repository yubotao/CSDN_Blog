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
 * @Date: Created in 11:16 2018/11/22
 * @Modified By:
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
public class MsgReceiverC_two {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitHandler
    public void process(String content){
        logger.info("处理器two接收处理队列A当中的消息： " + content);
    }
}
