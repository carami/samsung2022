package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample.MyBean;

@Configuration
public class MyBeanConfig {
	@Bean
	public MyBean bean1() {
		return new MyBean();
	}
	
	@Bean
	public MyBean bean2() {
		return new MyBean();
	}

}
