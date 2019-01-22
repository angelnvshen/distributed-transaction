package own.stu.mq.withrabbitmq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableBinding({CustomerNumInShopSource.class})
public class MessageListener {

  @StreamListener(CustomerNumInShopSource.CUSTOMER_NUM_INPUT)
  public void numInput(@Payload Long shopId) {

    System.out.println(shopId);
  }
}