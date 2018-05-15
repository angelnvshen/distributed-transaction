package own.stu.distributedTransaction.pay.app.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import own.stu.distributedTransaction.pay.service.api.message.RpTransactionMessageServiceApi;
import own.stu.distributedTransaction.pay.service.api.trade.RpTradePaymentServiceApi;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(clients = {RpTransactionMessageServiceApi.class, RpTradePaymentServiceApi.class})
@ComponentScan(basePackages = "own.stu.distributedTransaction.pay")
@EnableScheduling
@PropertySource("classpath*:pay-service-api.properties") //添加其他的 .properties 文件
public class PayAppMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayAppMessageApplication.class, args);
    }
}
