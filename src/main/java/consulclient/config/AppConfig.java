package consulclient.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("consulclient")
public class AppConfig {


	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}

}
