package own.stu.distributedTransaction.pay.web.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = "own.stu.distributedTransaction")
public class PayWebShopApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(PayWebShopApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "redirect:index";
    }
}