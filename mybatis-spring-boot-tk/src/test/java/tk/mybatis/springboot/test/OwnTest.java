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

        Semaphore semaphore = new Semaphore(100);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i =0;i<100;i++)
            service.submit(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sendMeg();
            });
        TimeUnit.SECONDS.sleep(10);
        semaphore.release(100);
    }

    private void sendMeg(){
        String url = "http://localhost:9090/selectForUpdate?id=1";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, null, String.class);
        System.out.println(response);
    }
}
