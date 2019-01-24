package own.stu.mq.withrabbitmq;

import lombok.Data;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.Payload;
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
  public void handle(People people){
    System.out.println("Received: " + people);
  }

  @Data
  public static class People{
    private String name;
  }
}