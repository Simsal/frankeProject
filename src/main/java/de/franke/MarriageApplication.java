package de.franke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.franke.security.SecurityConfiguration;

@SpringBootApplication
public class MarriageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarriageApplication.class, args);
	}
	
	@Bean
	public SecurityConfiguration loadSecurity(){
		return new SecurityConfiguration();
	}

	
}