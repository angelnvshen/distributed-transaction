package own.stu.mq.withrabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(CustomerNumInShopSource.class)
public class CustomerNumMessageSender {

  @Autowired
  private CustomerNumInShopSource customerNumInShopSource;

  public void send(Long shopId) {
    customerNumInShopSource.output().send(MessageBuilder.withPayload(shopId).build());
  }
}
