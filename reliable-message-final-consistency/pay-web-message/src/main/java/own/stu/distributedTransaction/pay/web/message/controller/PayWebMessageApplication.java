package own.stu.distributedTransaction.pay.web.message.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.File;
import java.net.URL;

/**
 * Created by CHANEL on 2018/5/6.
 */
@Controller
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = {"own.stu.distributedTransaction.pay", "own.stu.distributedTransaction.common.core.config"})
@MapperScan(basePackages = "own.stu.distributedTransaction.pay.service.*.dao")
public class PayWebMessageApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PayWebMessageApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PayWebMessageApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "redirect:login";
    }

}
