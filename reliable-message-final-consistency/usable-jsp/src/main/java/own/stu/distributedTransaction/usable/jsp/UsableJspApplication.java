package own.stu.distributedTransaction.usable.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@SpringBootApplication
@ServletComponentScan
public class UsableJspApplication  extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(UsableJspApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "redirect:index";
	}
}