package own.stu.withjsp.embeddedtomcat;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by dell on 2017/1/5.
 */
public class AppServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EmbeddedTomcatApplication.class);
    }
}
