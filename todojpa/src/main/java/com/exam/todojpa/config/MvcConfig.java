package com.exam.todojpa.config;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.exam.todojpa"})
public class MvcConfig implements WebMvcConfigurer{
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOriginPatterns("*")
				.allowedMethods("OPTIONS", "HEAD", "GET", "PUT", "POST", "DELETE", "PATCH").allowCredentials(true);
	}
	
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		final ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(com.fasterxml.jackson.databind.SerializationFeature.
				WRITE_DATES_AS_TIMESTAMPS, false); // iso 표준 데이트 문자열 형식을 사용
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);//  null인 데이터는 json결과에 나타나지 않습니다.
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // 예쁘게 보여준다. 
		converter.setObjectMapper(objectMapper);

		builder.serializationInclusion(JsonInclude.Include.NON_NULL); // null이 아닐 경우,비어있지 않을 겨우 변환한다.
		builder.serializationInclusion(JsonInclude.Include.NON_EMPTY);

		// Add settings to converter, builder
		converters.add(converter);
		converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
	}
}
