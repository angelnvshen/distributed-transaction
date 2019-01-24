package own.stu.mq.withrabbitmq;

import java.util.concurrent.TimeUnit;
import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({CustomerNumInShopSource.class, Sink.class})
public class MessageListener {

  @StreamListener(CustomerNumInShopSource.CUSTOMER_NUM_INPUT)
  public void numInput(@Payload Long shopId) {

    System.out.println(shopId);
  }

//  @StreamListener(CustomerNumInShopSource.INPUT_CUSTOMIZED)
  @StreamListener(Sink.INPUT)
  @SendTo(Source.OUTPUT)
  public People handle(People people) throws InterruptedException {
    System.out.println("Received: " + people);
    TimeUnit.SECONDS.sleep(3);
    people.setAge(people.getAge() + 1);
    return people;
  }

  @Data
  public static class People{
    private Integer age;
    private String name;
  }
}