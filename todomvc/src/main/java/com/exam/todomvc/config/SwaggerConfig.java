package com.exam.todomvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
@SuppressWarnings("unchecked")
public class SwaggerConfig {

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
	.groupName(groupName)
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.exam.todomvc"))
	.paths(predicate)
	.apis(RequestHandlerSelectors.any())
	.build();
	}
}
