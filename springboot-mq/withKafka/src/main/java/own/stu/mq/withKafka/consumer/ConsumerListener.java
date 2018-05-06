package own.stu.mq.withKafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import own.stu.mq.withKafka.domain.User;

/**
 * Created by CHANEL on 2018/5/4.
 */
@Component
public class ConsumerListener {

    @KafkaListener(topics="test2")
    public void consumer(String message){
        System.out.println(message);
    }

    @KafkaListener(topics="test-obj")
    public void consumer(User message){
        System.out.println(message);
    }

}
