package own.stu.distributedTransaction.pay.app.queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import own.stu.distributedTransaction.pay.service.api.account.RpAccountingVoucherServiceApi;
import own.stu.distributedTransaction.pay.service.api.message.RpTransactionMessageServiceApi;
import own.stu.distributedTransaction.pay.service.api.trade.RpTradePaymentQueryServiceApi;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(
        clients = {RpTransactionMessageServiceApi.class,
        RpTradePaymentQueryServiceApi.class,
                RpAccountingVoucherServiceApi.class})
@ComponentScan(basePackages = "own.stu.distributedTransaction.pay")
@EnableScheduling
public class PayAppQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayAppQueueApplication.class, args);
    }
}
