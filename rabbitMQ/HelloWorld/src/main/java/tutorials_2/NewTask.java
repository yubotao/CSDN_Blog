package tutorials_2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 17:07 2018/3/9
 * @Modified By:
 */
public class NewTask {
    private final static String QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        String message = getMessage(args);
//        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        System.out.println("[x] Sent '" + message + "'" );

        channel.close();
        connection.close();
    }

    private static String getMessage(String[] strings){
        if (strings.length < 1){
            return "Hello World!";
        }
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter){
        int length = strings.length;
        if(length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++){
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}
