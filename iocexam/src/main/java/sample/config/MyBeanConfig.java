package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample.MyBean;

@Configuration
public class MyBeanConfig {
	
	@Bean
	public MyBean myBean() {
		return new MyBean();
	}

	
	@Bean
	public MyBean myBean2() {
		return new MyBean();
	}
}
