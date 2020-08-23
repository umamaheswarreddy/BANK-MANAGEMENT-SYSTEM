package com.cts;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@RestController
@CrossOrigin(origins = "http://localhost:9191")
public class UserRegistrationApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}


	@Bean
	Docket configureSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.build()
				
				.apiInfo(new ApiInfo("USER-REGISTRATION AND BANK ACCOUNT SETUP API Documentation",
						" USER-REGISTRATION AND BANK ACCOUNT API for employees",
						"1.0.0",
						"USER is root",
						new Contact("Mahesh", "www.maheshuma.com", "maheshuma666S@gmail.com"), 
						"Standard API License",
						"www.mahesh.com",
						Collections.emptyList()));
		
}
	@Bean
	public WebMvcConfigurer configure() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/*").allowedOrigins("http://localhost:9000");
			}
			
		};
	}


}
