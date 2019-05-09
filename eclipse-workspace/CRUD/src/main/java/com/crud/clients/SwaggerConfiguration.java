package com.crud.clients;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.crud.clients.controller.CrudController;
import com.google.common.collect.Sets;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@PropertySource("classpath:swagger.properties")
@ComponentScan(basePackageClasses = { 
  CrudController.class})
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean // Create Docket bean (default configuration)
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select() // To give me apis() and path() methods for filtering
																// documents controllers
				.apis(RequestHandlerSelectors.basePackage("com.crud.clients")) // To filter the API with .basePackage .
				.apis(RequestHandlerSelectors.any()) // Any RequestHandler satisfies this condition
				.paths(regex("/.*")) // Generate the documentation just for that route ("/.*")
				.build() // Intended to be the primary interface.
				.apiInfo(swaggerStaticApiInfo()) //To implement the title and description in the API
				.consumes(Sets.newHashSet("application/json")) //MIME types consume = GET (Json, XML, html, etc)
				.produces(Sets.newHashSet("application/json")); // produces = PUT, POST (Json, XML, html, etc)
	}

	private ApiInfo swaggerStaticApiInfo() {
		
		return new ApiInfoBuilder()
				.title(" Services ")
				.description(" CRUD Back End Java Development ")
				.build();
	}
}

//Documentation http://localhost:3002/swagger-ui.html
//JSON generated (using SwaggerEditor) http://localhost:3002/v2/api-docs