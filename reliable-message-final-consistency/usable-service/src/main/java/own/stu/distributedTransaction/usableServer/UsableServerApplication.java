package own.stu.distributedTransaction.usableServer;

//特别注意，下面的是 tk.MapperScan

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liuzh
 * @since 2015-12-12 18:22
 */
@Controller
@EnableWebMvc
@SpringBootApplication
@EnableDiscoveryClient // 激活服务发现客户端
@MapperScan(basePackages = "own.stu.distributedTransaction.usableServer.mapper")
public class UsableServerApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {
    private Logger logger = LoggerFactory.getLogger(UsableServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UsableServerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("服务启动完成!");
    }

    @RequestMapping("/")
    String home() {
        return "redirect:countries";
    }
}
