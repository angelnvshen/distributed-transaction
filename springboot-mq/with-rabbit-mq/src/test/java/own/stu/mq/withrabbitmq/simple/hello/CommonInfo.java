package own.stu.mq.withrabbitmq.simple.hello;

import com.rabbitmq.client.ConnectionFactory;

public class CommonInfo {

  public static ConnectionFactory getConnectionFactory(){
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("172.16.2.165");
    factory.setPort(5672);
    factory.setUsername("lsrabbit");
    factory.setPassword("lsrabbit");
    factory.setVirtualHost("rabbit");

    return factory;
  }

}
