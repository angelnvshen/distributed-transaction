package own.stu.distributedTransaction.pay.web.message.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by CHANEL on 2018/5/6.
 */
@Controller
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = {"own.stu.distributedTransaction.pay"})
@MapperScan(basePackages = "own.stu.distributedTransaction.pay.service.*.dao")
public class PayWebMessageAPIApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PayWebMessageAPIApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PayWebMessageAPIApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "redirect:message/test";
    }

}
