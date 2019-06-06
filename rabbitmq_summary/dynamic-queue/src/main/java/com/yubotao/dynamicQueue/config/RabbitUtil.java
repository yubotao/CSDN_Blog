package com.yubotao.dynamicQueue.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 13:54 2019/5/31
 * @Modified By:
 */
@Component
public class RabbitUtil {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final String DIRECT_EXCHANGE_NAME = "test-dynamic";

    @Resource
    private RabbitAdmin rabbitAdmin;

    @Resource
    private RabbitTemplate rabbitTemplate;

    // 配置发送格式
    @Bean
    public AmqpTemplate amqpTemplate(){
        // 使用jackson 消息转换器
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        rabbitTemplate.setEncoding("UTF-8");
        // 开启return callback
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            String correlationId = message.getMessageProperties().getCorrelationId();
            logger.info("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId,replyCode,replyText,exchange,routingKey);
        });
        // 消息确认
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (ack){
                logger.info("消息发送到exchange成功");
            }else {
                logger.info("消息发送到exchange失败,原因: {}", cause);
            }
        });
        return rabbitTemplate;
    }

    public Message getMessage(String messageType, Object msg){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(messageType);
        Message message = new Message(msg.toString().getBytes(), messageProperties);
        return message;
    }

    public void sendToQueue(String queueName, String message){
        DirectExchange exchange = createExchange(DIRECT_EXCHANGE_NAME);
        addExchange(exchange);
        Queue queue = createQueue(queueName);
        addQueue(queue);
        addBinding(queue, exchange, queueName);
        rabbitTemplate.convertAndSend(exchange.getName(), queueName, message);
    }

    public String receiveFromQueue(String queueName){
        String message = (String)rabbitTemplate.receiveAndConvert(queueName);
        System.out.println("Receive: " + message);
        return message;
    }

    public DirectExchange createExchange(String exchangeName){
        return new DirectExchange(exchangeName, true, false);
    }

    public Queue createQueue(String queueName){
        return QueueBuilder.durable(queueName).build();
    }

    /**
     * 创建时限队列，可自动删除
     * @param queueName
     * @return
     */
    public Queue createExpiresQueue(String queueName){
        return QueueBuilder.durable(queueName)
//                .withArgument("x-message-ttl", delayMillis) // 死信时间
                .withArgument("x-expires", 3000) // 设置队列自动删除时间
//                .withArgument("x-dead-letter-exchange", rabbitConfig.getExchange()) // 死信重新投递的交换机
//                .withArgument("x-dead-letter-routing-key", rabbitConfig.getQueue()) // 路由到队列的routingKey
                .build();
    }

    /**
     * 使用一个routingKey绑定一个队列到一个匹配型交换器
     * @param queue
     * @param exchange
     * @param routingKey
     */
    public void addBinding(Queue queue, DirectExchange exchange, String routingKey){
        Binding binding = BindingBuilder.bind(queue).to(exchange).with(routingKey);
        rabbitAdmin.declareBinding(binding);
    }

    /**
     * 创建一个指定的Queue
     * @param queue
     * @return queueName
     */
    public String addQueue(Queue queue){
        return rabbitAdmin.declareQueue(queue);
    }

    public boolean deleteQueue(String queueName){
        return rabbitAdmin.deleteQueue(queueName);
    }

    /**
     * 创建Exchange
     * @param exchange
     */
    public void addExchange(AbstractExchange exchange){
        rabbitAdmin.declareExchange(exchange);
    }

    public boolean deleteExchange(String exchangeName){
        return rabbitAdmin.deleteExchange(exchangeName);
    }

}
