package com.crud.clients;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean // Create Docket bean (default configuration)
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select() // To give me apis() and path() methods for filtering
																// documents controllers
				.apis(RequestHandlerSelectors.basePackage("com.crud.clients")) // To filter the API with .basePackage
				.paths(regex("/.*")) // Generate the documentation just for that route ("/.*")
				.build(); // Intended to be the primary interface.
	}
}
//Documentation http://localhost:3002/swagger-ui.html
//Configuration http://localhost:3002/v2/api-docs