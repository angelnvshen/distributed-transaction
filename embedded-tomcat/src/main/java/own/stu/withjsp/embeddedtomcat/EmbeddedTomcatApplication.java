package own.stu.withjsp.embeddedtomcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@ServletComponentScan
@SpringBootApplication
public class EmbeddedTomcatApplication extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(EmbeddedTomcatApplication.class, args);
	}
}
