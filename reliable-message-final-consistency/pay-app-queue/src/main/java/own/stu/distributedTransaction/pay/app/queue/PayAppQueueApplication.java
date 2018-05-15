package own.stu.distributedTransaction.pay.app.queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import own.stu.distributedTransaction.pay.service.api.account.RpAccountingVoucherServiceApi;
import own.stu.distributedTransaction.pay.service.api.message.RpTransactionMessageServiceApi;
import own.stu.distributedTransaction.pay.service.api.trade.RpTradePaymentServiceApi;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(
        clients = {RpTransactionMessageServiceApi.class,
                RpTradePaymentServiceApi.class,
                RpAccountingVoucherServiceApi.class})
@ComponentScan(basePackages = "own.stu.distributedTransaction.pay")
@EnableScheduling
//可读取classpath下的配置文件
@PropertySource("classpath:pay-service-api.properties") //添加其他的 .properties 文件
//可读取文件系统下的外部配置文件
//@PropertySource("file:C:\\Users\\CHANEL\\Desktop\\pay-service-api.properties") //添加其他的 .properties 文件
public class PayAppQueueApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayAppQueueApplication.class, args);
    }
}
