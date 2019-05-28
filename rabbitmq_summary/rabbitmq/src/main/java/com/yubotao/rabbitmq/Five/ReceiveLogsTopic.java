package com.yubotao.rabbitmq.Five;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:04 2018/11/20
 * @Modified By:
 */
public class ReceiveLogsTopic {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        String queueName = channel.queueDeclare().getQueue();

        if (args.length < 1) {
            System.err.println("Usage: ReceiveLogsTopic [binding_key]...");
            System.exit(1);
        }
        // binding key 格式是用来和routing key匹配的，拥有两个特殊字符
        // "*"，代表一个单词；如 "*.orange.*" 可匹配  "lazy.orange.elephant" 和 "quick.orange.rabbit"
        // "#"，代表0个或多个单词；如 "lazy.#" 可匹配 "lazy.pink.rabbit" 和 "lazy.orange.male.rabbit"； 但是注意使用"*"时， key的长度
        // 如果不适用上述两个特殊字符，则topic 就是 direct 模式
        for (String bindingKey : args) {
            channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
        }

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }

}
