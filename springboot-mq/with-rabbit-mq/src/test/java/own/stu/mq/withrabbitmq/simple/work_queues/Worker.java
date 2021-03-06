package own.stu.mq.withrabbitmq.simple.work_queues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import own.stu.mq.withrabbitmq.simple.hello.CommonInfo;

public class Worker {

  private static final String TASK_QUEUE_NAME = "task_queue";

  public static void consumer() throws Exception {

    ConnectionFactory factory = CommonInfo.getConnectionFactory();

    final Connection connection = factory.newConnection();
    final Channel channel = connection.createChannel();

    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    channel.basicQos(1);

    DeliverCallback deliverCallback = (consumerTag, delivery) -> {
      String message = new String(delivery.getBody(), "UTF-8");

      System.out.println(Thread.currentThread().getName() + " [x] Received '" + message + "'");
      try {
        doWork(message);
      } finally {
        System.out.println(Thread.currentThread().getName() + " [x] Done");
        channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
      }
    };
    channel.basicConsume(TASK_QUEUE_NAME, false, deliverCallback, consumerTag -> {
    });
  }

  private static void doWork(String task) {
    for (char ch : task.toCharArray()) {
      if (ch == '.') {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException _ignored) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
}