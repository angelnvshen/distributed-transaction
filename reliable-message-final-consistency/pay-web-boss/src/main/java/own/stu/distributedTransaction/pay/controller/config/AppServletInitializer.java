package own.stu.distributedTransaction.pay.controller.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import own.stu.distributedTransaction.pay.controller.PayWebBossApplication;

/**
 * Created by dell on 2017/1/5.
 */
public class AppServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PayWebBossApplication.class);
    }
}
