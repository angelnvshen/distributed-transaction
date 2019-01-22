package own.stu.mq.withrabbitmq.simple.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.util.StringUtils;
import own.stu.mq.withrabbitmq.simple.hello.CommonInfo;

public class EmitLogTopic {

  private static final String EXCHANGE_NAME = "direct_logs";

  public static void producer(String severity, String message) throws Exception {
    ConnectionFactory factory = CommonInfo.getConnectionFactory();

    try (Connection connection = factory.newConnection();
        Channel channel = connection.createChannel()) {

      channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

      severity = StringUtils.isEmpty(severity) ? "info" : severity;
      message = StringUtils.isEmpty(message) ? "info: Hello World!" : message;

      channel.basicPublish(EXCHANGE_NAME, severity, null, message.getBytes("UTF-8"));
      System.out.println(Thread.currentThread().getName() + " [x] Sent '" + severity + "':'" + message + "'");
    }
  }

  private static String getSeverity(String[] strings) {
    if (strings.length < 1) {
      return "info";
    }
    return strings[0];
  }

  private static String getMessage(String[] strings) {
    if (strings.length < 2) {
      return "Hello World!";
    }
    return joinStrings(strings, " ", 1);
  }

  private static String joinStrings(String[] strings, String delimiter, int startIndex) {
    int length = strings.length;
    if (length == 0) {
      return "";
    }
    if (length < startIndex) {
      return "";
    }
    StringBuilder words = new StringBuilder(strings[startIndex]);
    for (int i = startIndex + 1; i < length; i++) {
      words.append(delimiter).append(strings[i]);
    }
    return words.toString();
  }
}