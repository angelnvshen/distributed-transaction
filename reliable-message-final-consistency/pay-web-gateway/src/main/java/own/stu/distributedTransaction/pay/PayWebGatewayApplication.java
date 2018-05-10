package own.stu.distributedTransaction.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

@Controller
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = {"own.stu.distributedTransaction.pay", "own.stu.distributedTransaction.common.core.config"})
@MapperScan(basePackages = "own.stu.distributedTransaction.pay.service.*.dao")
public class PayWebGatewayApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(PayWebGatewayApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "index";
    }
}