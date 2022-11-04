package com.exam.todojpa.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;

@SpringJUnitConfig(classes = {ApplicationConfig.class})
@DisplayName("todo service Test!!!")
public class TodoServiceTest {
	private static Logger logger = LoggerFactory.getLogger(TodoServiceTest.class);
	
	@Autowired
	private TodoService todoService;
	
	@Test
	@SqlGroup({
		@Sql(value = "classpath:db/test-data.sql", config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"), executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
		@Sql(value = "classpath:db/clean-up.sql", config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"), executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD), })

	void getTodos() {
		logger.info("-----getTodos()~~~~ ");
		List<Todo> todos =	todoService.getTodos();
		assertNotNull(todos);
		logger.info(todos.size()+"============================");
	}
}
