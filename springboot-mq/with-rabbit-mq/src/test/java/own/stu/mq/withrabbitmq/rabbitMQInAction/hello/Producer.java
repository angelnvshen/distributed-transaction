package own.stu.mq.withrabbitmq.rabbitMQInAction.hello;

import com.rabbitmq.client.AMQP.Exchange;
import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import own.stu.mq.withrabbitmq.simple.hello.CommonInfo;

public class Producer {

  public static String exchange_name = "exchange_demo";
  public static String queue_name = "queue_demo";
  public static String routing_key_name = "routing_key_demo";

  public static void sendMessage() {

    ConnectionFactory connectionFactory = CommonInfo.getConnectionFactory();

    try(Connection connection = connectionFactory.newConnection();
    Channel channel = connection.createChannel();) {

      channel.exchangeDeclare(exchange_name, BuiltinExchangeType.DIRECT, false, false, false, null);
      channel.queueDeclare(queue_name, false, false, false, null);

      channel.queueBind(queue_name, exchange_name, routing_key_name);

      String message = "Hello , world !";

      channel.basicPublish(exchange_name, routing_key_name, null, message.getBytes());
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Producer.sendMessage();
  }
}
