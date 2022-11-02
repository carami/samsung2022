package com.exam.todomvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@SuppressWarnings("unchecked")
public class SwaggerConfig {
	private static final String API_NAME = "ToDo API";
	private static final String API_VERSION = "0.0.1";
	private static final String API_DESCRIPTION = "ToDo API 명세서";

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().
				title(API_NAME).
				version(API_VERSION).
				description(API_DESCRIPTION).
				build();
	}

	@Bean
	public Docket todosApi() {
		return getDocket("todos", Predicates.or(PathSelectors.regex("/api/todos.*")));
	}

	@Bean
	public Docket allApi() {
		return getDocket("전체", Predicates.or(PathSelectors.any()));
	}

	// swagger 설정.
	public Docket getDocket(String groupName, Predicate<String> predicate) {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.groupName(groupName)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.exam.todomvc"))
				.paths(predicate)
				.apis(RequestHandlerSelectors.any())
				.build();
	}
	
	

}
