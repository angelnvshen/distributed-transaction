package own.stu.mq.withrabbitmq.rabbitMQInAction.hello;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.AMQP.Exchange;
import com.rabbitmq.client.AMQP.Queue;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import java.util.HashMap;
import java.util.Map;
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
      /**
       * queueDeclare
       * autoDelete: 设置是否自动删除。为 true 则设置队列为自动删除。
       *  自动删除的前提是：至少有一个消费者连接到这个队列，之后所有与这个队列连接的消费者都断开时，才会自动删除。
       *  不能把这个参数错误地理解为：“当连接到此队列的所有客户端断开时，这个队列自动删除”，
       *  因为生产者客户端创建这个队列，或者没有消费者客户端与这个队列连接时，都不会自动删除这个队列。
       */
      // channel.queueDeclare(queue_name, false, false, true, null);
      channel.queueDeclare(queue_name, false, false, false, null);

      channel.queueBind(queue_name, exchange_name, routing_key_name);

      String message = "Hello , world !!!!";

//      channel.basicPublish(exchange_name, routing_key_name, null, message.getBytes());

      /*channel.basicPublish(exchange_name, routing_key_name,
          new BasicProperties.Builder()
              .contentType("text/plain")
              .priority(1)
              .build(),
          message.getBytes());*/

      /*Map<String, Object> header = new HashMap<>();
      header.put("time", "today");
      channel.basicPublish(exchange_name, routing_key_name,
          new BasicProperties.Builder()
              .headers(header)
              .build(),
          message.getBytes());*/

      channel.basicPublish(exchange_name, routing_key_name,
          new BasicProperties.Builder()
              .expiration("6000").build(),
          message.getBytes());
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  public static void deleteQueue(){
    ConnectionFactory connectionFactory = CommonInfo.getConnectionFactory();

    try(Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();) {

      channel.queueDelete(queue_name);
    }catch (Exception e){
      e.printStackTrace();
    }
  }



  public static void main(String[] args) {
    Producer.sendMessage();
//    Producer.deleteQueue();
  }
}
