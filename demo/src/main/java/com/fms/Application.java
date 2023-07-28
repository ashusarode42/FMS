package com.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//This is the main file of the Feedback Management System
@SpringBootApplication
@ComponentScan(basePackages = "com.fms")
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Running on 8086");

	}

	//Swagger api is used to do url documentation
	@Bean
	public Docket fmsapi() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.fms"))
				.build();
		// swagger documentation can be accessed on the following URL
		// http:localhost:8086/swagger-ui.html
	}

}
