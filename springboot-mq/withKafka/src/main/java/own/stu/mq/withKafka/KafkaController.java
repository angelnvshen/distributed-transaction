package own.stu.mq.withKafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import own.stu.mq.withKafka.domain.User;

/**
 * Created by CHANEL on 2018/5/4.
 */
@RestController
public class KafkaController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("send/message")
    public String send(String message){
        kafkaTemplate.send("test2",message);
        return "success";
    }

    @GetMapping("send/obj")
    public String sendUser(@RequestParam(value = "name", required = true)String name){
        User user = new User();
        user.setAge(20);
        user.setDesc("微风纪委");
        user.setId(1000l);
        user.setName(name);
        kafkaTemplate.send("test-obj", user);
        return "success";
    }
}
