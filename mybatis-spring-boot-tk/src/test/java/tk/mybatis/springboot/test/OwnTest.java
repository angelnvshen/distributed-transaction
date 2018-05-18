package tk.mybatis.springboot.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

/**
 * Created by CHANEL on 2018/5/16.
 */
public class OwnTest {

    @Test
    public void testSelectForUpdate(){

        String url = "http://localhost:9090/selectForUpdate?id=1";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, null, String.class);
        System.out.println(response);
    }

    @Test
    public void testMultiSelectForUpdate() throws InterruptedException {

        int threadNum = 100;
//        Semaphore semaphore = new Semaphore(100);
//        CountDownLatch latch = new CountDownLatch(threadNum);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i =0;i<threadNum;i++)
            service.submit(()->{
                /*try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
//                latch.countDown();
                sendMeg();
            });
        TimeUnit.HOURS.sleep(1);
//        semaphore.release(100);
//        latch.await();
    }

    private void sendMeg(){
//        String url = "http://localhost:9090/selectForUpdate?id=1";
        String url = "http://localhost:9090/exchangeAmount";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, null, String.class);
        System.out.println(response);
    }
}
