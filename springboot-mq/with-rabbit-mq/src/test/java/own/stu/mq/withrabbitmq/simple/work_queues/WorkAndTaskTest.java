package own.stu.mq.withrabbitmq.simple.work_queues;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class WorkAndTaskTest {

  @Test
  public void testWorker() throws InterruptedException {

    ExecutorService service = Executors.newFixedThreadPool(2);


    for(int i= 0; i<2;i++){
      service.submit(new Thread(()->{
        try {
          Worker.consumer();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }), "thread-"+ i);
    }

    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
  }

  @Test
  public void testProducer() throws Exception {
    NewTask.produce("hello....");
  }

}
