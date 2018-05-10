package own.stu.distributedTransaction.pay.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Created by CHANEL on 2018/5/6.
 */
@Controller
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = {"own.stu.distributedTransaction.pay", "own.stu.distributedTransaction.common.core.config"})
@MapperScan(basePackages = "own.stu.distributedTransaction.pay.service.*.dao")
public class PayWebBossApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PayWebBossApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PayWebBossApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "redirect:login";
    }
}
