package own.stu.distributedTransaction.pay.web.shop.config;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.URL;

@Configuration
public class EmbeddedServletConfig {

    /* 仅仅 内置tomcat使用*/
    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
        ConfigurableEmbeddedServletContainer factory = new TomcatEmbeddedServletContainerFactory();

        URL xmlPath = this.getClass().getClassLoader().getResource("");
        String customer_jsp_path = xmlPath.getFile().replaceAll("target/classes", "src/main/webapp");

        factory.setDocumentRoot(new File(customer_jsp_path));
        return (EmbeddedServletContainerFactory) factory;
    }
}
