package com.exam.todojpa.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
@Configuration
@ComponentScan(basePackages = {"com.exam.todojpa.dao","com.exam.todojpa.service"})
//@EnableTransactionManagement
public class ApplicationConfig {
//	@Bean(name = "dataSource")
//	public DataSource dataSource() {
//		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//		dataSource.setDriverClass(org.h2.Driver.class);
//		dataSource.setUsername("sa");
//		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test;MODE=MySQL");
//		dataSource.setPassword("");
//		return dataSource;
//	}

	

	
}
