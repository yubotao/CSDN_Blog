package com.yubotao.rabbitmq.Two;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:47 2018/11/19
 * @Modified By:
 */
public class Worker {
    private final static String TASK_QUEUE_NAME = "hello_two_durable";

    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            // 设置队列不会丢失
            boolean durable = true;

            channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            // 这保证rabbit MQ一次不会给worker超过一个message，也就是说，如果当前worker处于busy，那么新的消息就会分发到其他not busy的worker上。
            channel.basicQos(1);

            Consumer consumer = new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException{
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");

                    try {
                        doWork(message);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    } finally {
                        System.out.println(" [x] Done");
                        // 用于设置ack
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                }
            };
            boolean autoAck = false; // acknowledgment is covered below
            // 如果ack Boolean 为true，则可能丢失数据
            channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);

        }catch (TimeoutException e){
            e.printStackTrace();
        }
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()){
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
