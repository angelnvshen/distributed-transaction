package own.stu.mq.withrabbitmq.simple.work_queues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import own.stu.mq.withrabbitmq.simple.hello.CommonInfo;

public class NewTask {

  private static final String TASK_QUEUE_NAME = "task_queue";

  public static void produce(String message) throws Exception {
    ConnectionFactory factory = CommonInfo.getConnectionFactory();

    try (Connection connection = factory.newConnection();
        Channel channel = connection.createChannel()) {
      channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

      channel.basicPublish("", TASK_QUEUE_NAME,
          MessageProperties.PERSISTENT_TEXT_PLAIN,
          message.getBytes("UTF-8"));
      System.out.println(" [x] Sent '" + message + "'");
    }
  }

}