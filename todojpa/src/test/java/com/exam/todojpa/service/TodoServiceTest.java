package com.exam.todojpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.config.SimpleTestConfig;
import com.exam.todojpa.domain.Todo;

@SpringJUnitConfig(classes = {SimpleTestConfig.class,ApplicationConfig.class})
@DisplayName("todo service test!!!")
@ActiveProfiles("test")
public class TodoServiceTest {
private static Logger logger = LoggerFactory.getLogger(TodoServiceTest.class);
	
	@Autowired
	TodoService todoService;
	
	@BeforeAll
	static void setUp() {
		logger.info("--> @BeforeAll - 이 클래스의 모든 테스트 메소드를 실행하기 전에 실행합니다.");
	}

	@AfterAll
	static void tearDown(){
		logger.info("--> @AfterAll - 이 클래스의 모든 테스트 메소드를 실행한 다음에 실행합니다.");
	}

	@BeforeEach
	void init() {
		logger.info("--> @BeforeEach - 이 클래스의 각 테스트 메소드 실행하기 전에 실행합니다.");
	}

	@AfterEach
	void dispose() {
		logger.info("--> @AfterEach - 이 클래스의 각 테스트 메소드 실행한 다음에 실행합니다.");
	}
	
	@Test
	public void tes1() {
		logger.info("test1");
	}
	@Test
	public void test2() {
		logger.info("test2");
	}
	
	@Test
	@DisplayName("todo 목록 구하기 테스트")
	@SqlGroup({
			@Sql(value = "classpath:db/test-data.sql",
					config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
					executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
			@Sql(value = "classpath:db/clean-up.sql",
					config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
					executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD),
	})
	public void findAll() {
		logger.info("]==============================findAll============================================");
		List<Todo> result = todoService.getTodos();
		assertNotNull(result);
		assertEquals(3, result.size());
	}

}
