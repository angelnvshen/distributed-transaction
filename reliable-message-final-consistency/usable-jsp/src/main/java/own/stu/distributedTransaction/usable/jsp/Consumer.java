package own.stu.distributedTransaction.usable.jsp;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by CHANEL on 2018/5/7.
 */
@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")
    private void receivedMessage(String message){
        System.out.println(message);
    }
}
