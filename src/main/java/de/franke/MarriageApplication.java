package de.franke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import de.franke.security.SecurityConfiguration;

@SpringBootApplication
@EnableJpaRepositories
@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@ComponentScan
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MarriageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarriageApplication.class, args);
	}
	
	@Bean
	public SecurityConfiguration loadSecurity(){
		return new SecurityConfiguration();
	}

	
}