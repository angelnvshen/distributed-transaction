package own.stu.distributedTransaction.usable.jsp;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "sample.queue")
    public void receivedQueue(String text){
        System.out.println("received : " + text);
    }
}
