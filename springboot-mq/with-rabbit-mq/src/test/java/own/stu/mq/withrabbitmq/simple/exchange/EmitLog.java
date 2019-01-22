package own.stu.mq.withrabbitmq.simple.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.util.StringUtils;
import own.stu.mq.withrabbitmq.simple.hello.CommonInfo;

public class EmitLog {

  private static final String EXCHANGE_NAME = "logs";

  public static void produce(String message) throws Exception {

    ConnectionFactory factory = CommonInfo.getConnectionFactory();

    try (Connection connection = factory.newConnection();
         Channel channel = connection.createChannel()) {

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        message = StringUtils.isEmpty(message) ? "info: Hello World!" : message;

        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");
    }
  }
}