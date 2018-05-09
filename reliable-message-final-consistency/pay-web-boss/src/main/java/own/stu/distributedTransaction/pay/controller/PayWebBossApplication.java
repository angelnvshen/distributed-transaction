package own.stu.distributedTransaction.pay.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by CHANEL on 2018/5/6.
 */
@Controller
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = "own.stu.distributedTransaction")
@MapperScan(basePackages = "own.stu.distributedTransaction.pay.service.*.dao")
public class PayWebBossApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(PayWebBossApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "redirect:login";
    }
}