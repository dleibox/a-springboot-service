package a.springboot.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ASpringbootServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ASpringbootServiceApplication.class);

	public static void main(String[] args) {
		log.info("-----------------------------------------");
		log.info("[ App ] main() starting !", Arrays.toString(args));
		log.info("-----------------------------------------");
		
		SpringApplication.run(ASpringbootServiceApplication.class, args);
		
		log.info("-----------------------------------------");
		log.info("[ App ] main() end !", Arrays.toString(args));
		log.info("-----------------------------------------");
	}

	@Bean
	public RestTemplate getRestTemplate() {
		log.info("[ RestTemplate ] Create an instance of RestTemplate");
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/")
	public String hello() {
		return "Hello A Spring Boot Service";
	}
}
