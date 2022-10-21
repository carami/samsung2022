package com.exam.todojpa.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;


@Configuration
public class SimpleTestConfig {

	private static Logger logger = LoggerFactory.getLogger(SimpleTestConfig.class);

	@Bean(name = "dataSource", destroyMethod = "close")
	public DataSource dataSource() {
		try {
			EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
			return dbBuilder.setType(EmbeddedDatabaseType.H2).build();
		} catch (Exception e) {
			logger.error("임베디드 DataSource 빈을 생성할 수 없습니다!", e);
			return null;
		}
	}

}
