package com.exam.firstspring.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.exam.firstspring.dao.TodoDao;
import com.exam.firstspring.dao.TodoDaoImpl;
import com.exam.firstspring.ioc.UserBean;
import com.exam.firstspring.service.TodoService;

@Configuration
@ComponentScan(basePackages = {"com.exam.firstspring"})
public class AppConfig {
//
//	@Bean
//	public UserBean userBean() {
//		return new UserBean();
//	}
//	
//	@Bean
//	public TodoDao todoDao() {
//		return new TodoDaoImpl();
//	}
//	
//	@Bean
//	public TodoService todoService() {
//		return new TodoService(todoDao());
//	}
}
