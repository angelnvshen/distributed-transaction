package own.stu.mq.withrabbitmq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * 店铺新客户数量
 */
@Component
public interface CustomerNumInShopSource {
  String CUSTOMER_NUM_INPUT = "CUSTOMER-NUM-INPUT";
  String CUSTOMER_NUM_OUTPUT = "CUSTOMER-NUM-OUTPUT";

  @Output(CustomerNumInShopSource.CUSTOMER_NUM_OUTPUT)
  MessageChannel output();

  @Input(CustomerNumInShopSource.CUSTOMER_NUM_INPUT)
  SubscribableChannel input();
}
