package own.stu.distributedTransaction.usable.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tk.mybatis.spring.annotation.MapperScan;

import java.io.File;
import java.net.URL;

@Controller
@SpringBootApplication
@ServletComponentScan
@ComponentScan(basePackages = "own.stu.distributedTransaction")
@MapperScan(basePackages = "own.stu.distributedTransaction.pay.service.message.dao")
public class UsableJspApplication  extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UsableJspApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(UsableJspApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "redirect:index";
	}

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