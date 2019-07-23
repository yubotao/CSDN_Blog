package com.yubotao.rabbitmq_with_sb.receiver.ack;

import com.rabbitmq.client.Channel;
import com.yubotao.rabbitmq_with_sb.config.RabbitConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Service;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 16:58 2019/7/23
 * @Modified By:
 */
@Service("receiveConfirmTestListener")
public class ReceiverConfirmTestListener implements ChannelAwareMessageListener{
    @RabbitHandler
    @RabbitListener(queues = RabbitConfig.QUEUE_B)
    @Override
    public void onMessage(Message message, Channel channel) throws Exception{
        try {
            System.out.println("messageProperties：" + message.getMessageProperties());
            System.out.println("消息主体内容：" + new String(message.getBody()));
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            e.printStackTrace();
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
        }
    }
}
