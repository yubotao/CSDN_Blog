package tutorials_2;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 17:13 2018/3/9
 * @Modified By:
 */
public class Worker {
    private final static String QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        System.out.println("[*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1);// accept only one unack-ed message at a time (see below)

        final Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("[x] Received '" + message + "'");
                try {
                    doWork(message);
                }
//                 catch (InterruptedException e){
//                  e.printStackTrace();
//                }
                    finally {
                    System.out.println("[x] done");
                    channel.basicAck(envelope.getDeliveryTag(), false);
                }

            }
        };
//        boolean autoAck = true;
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }

    private static void doWork(String task){
        for(char ch : task.toCharArray()){
            if(ch == '.') {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException _ignored){
                    Thread.currentThread().interrupt();
                }

            }
        }
    }

}