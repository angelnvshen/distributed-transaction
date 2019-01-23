package own.stu.mq.withrabbitmq.rabbitMQInAction.hello;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.omg.PortableInterceptor.INACTIVE;
import own.stu.mq.withrabbitmq.simple.hello.CommonInfo;

public class Consumer {

  public static void receive(){
    ConnectionFactory connectionFactory = CommonInfo.getConnectionFactory();

    try(Connection connection = connectionFactory.newConnection();
      Channel channel = connection.createChannel();
    ){
      channel.basicQos(64);

      com.rabbitmq.client.Consumer consumer = new DefaultConsumer(channel){
        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
            throws IOException {
          System.out.println("receive message : " + new String(body));
          channel.basicAck(envelope.getDeliveryTag(), false);
        }
      };

      channel.basicConsume(Producer.queue_name, consumer);
      TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
    } catch (TimeoutException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Consumer.receive();
  }
}
