package own.stu.distributedTransaction.pay.web.message.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by CHANEL on 2018/5/6.
 */
@Controller
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = "own.stu.distributedTransaction.pay")
@MapperScan(basePackages = "own.stu.distributedTransaction.pay.service.message.dao")
public class PayWebMessageApplication  extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(PayWebMessageApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "redirect:login";
    }
}
