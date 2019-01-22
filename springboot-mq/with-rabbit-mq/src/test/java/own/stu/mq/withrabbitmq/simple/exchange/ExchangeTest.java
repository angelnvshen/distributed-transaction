package own.stu.mq.withrabbitmq.simple.exchange;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import own.stu.mq.withrabbitmq.simple.hello.Worker;

public class ExchangeTest {

  @Test
  public void testConsumer() throws Exception {

    ExecutorService service = Executors.newFixedThreadPool(2);

    for(int i= 0; i<3;i++){
      service.submit(new Thread(()->{
        try {
          ReceiveLogs.consumer();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }), "thread-"+ i);
    }


    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
  }

  @Test
  public void testProducer() throws Exception {
    EmitLog.produce("王菲为丰富");
  }
}
