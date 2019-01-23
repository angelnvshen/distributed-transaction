package own.stu.mq.withrabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WithRabbitMqApplication {

  public static void main(String[] args) {
    SpringApplication.run(WithRabbitMqApplication.class, args);
  }

  @Autowired
  private CustomerNumMessageSender customerNumMessageSender;

  @RequestMapping("send")
  public String sendMessage(Long shopId){
    customerNumMessageSender.send(shopId);
    return shopId + "";
  }
}

