package com.yubotao.rabbitmq.Six;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeoutException;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:46 2018/11/20
 * @Modified By:
 */
public class RPCClient {

    private Connection connection;
    private Channel channel;
    private String requestQueueName = "rpc_queue";

    public RPCClient() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        connection = factory.newConnection();
        channel = connection.createChannel();
    }

    public String call(String message) throws IOException, InterruptedException {
        final String corrId = UUID.randomUUID().toString();

        String replyQueueName = channel.queueDeclare().getQueue();
        AMQP.BasicProperties props = new AMQP.BasicProperties()
                .builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();
        // publish request message, with "replyTo" and "correlationId"
        channel.basicPublish("", requestQueueName , props, message.getBytes("UTF-8"));
        // suspend the main thread before the response arrives
        final BlockingQueue<String> response = new ArrayBlockingQueue<String>(1);

        String ctag = channel.basicConsume(replyQueueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                // check if the correlationId is the one we're looking for. If so, puts the response to BlockingQueue.
                if (properties.getCorrelationId().equals(corrId)){
                    response.offer(new String(body, "UTF-8"));
                }
            }

        });

        String result = response.take();
        channel.basicCancel(ctag);
        return result;
    }

    public void close() throws IOException {
        connection.close();
    }

    public static void main(String[] args) {
        RPCClient fibonacciRpc = null;
        String response = null;
        try {
            fibonacciRpc = new RPCClient();

            for (int i = 0; i < 32; i++){
                String i_str = Integer.toString(i);
                System.out.println(" [x] Requesting fib(" + i_str + ")");
                response = fibonacciRpc.call(i_str);
                System.out.println(" [.] Got '" + response + "'");
            }
        }catch (IOException | TimeoutException | InterruptedException e){
            e.printStackTrace();
        }finally {
            if (fibonacciRpc!= null) {
                try {
                    fibonacciRpc.close();
                }
                catch (IOException _ignore) {}
            }
        }
    }

}
