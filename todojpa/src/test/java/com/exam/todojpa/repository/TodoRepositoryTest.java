package com.exam.todojpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todojpa.config.SimpleTestConfig;
import com.exam.todojpa.domain.Todo;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(classes = SimpleTestConfig.class)
@DisplayName("todo jpa 테스트!!!")
@Transactional
public class TodoRepositoryTest {
	private static Logger logger = LoggerFactory.getLogger(TodoRepository.class);
	
	@Autowired
	private TodoRepository todoRepository;
	
	@BeforeAll
	static void setUp() {
		logger.info("------------------>@BeforeAll 메소드 실행!!!");
	}
	
	@AfterAll
	static void tearDown() {
		logger.info("------------------>@AfterAll 메소드 실행!!!");
	}
	
	@BeforeEach
	void init() {
		logger.info("------------------>@BeforeEach 메소드 실행!!!");
	}
	@AfterEach
	void dispose() {
		logger.info("------------------>@AfterEach 메소드 실행!!!");
	}
	
	@Test
	void test2() {
		logger.info("test2 메소드 실행!!!");
	}
	
	@Test
	void test3() {
		logger.info("test3 메소드 실행!!!");
	}
	
	@Test
	void save() {
		logger.info("save~~~");
		Todo todo = new Todo();
		todo.setTodo("junit test transation 실습");
		
		todo =todoRepository.save(todo);
		logger.info(todo.toString());
		
		assertNotNull(todo.getId());		
	}
	@DisplayName("전체 데이터를 읽어오는지에 대한 테스트")
	@Test
	@SqlGroup({
		@Sql(value = "classpath:db/test-data.sql",
				config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
				executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
		@Sql(value = "classpath:db/clean-up.sql",
				config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
				executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD),
})
	void findAll() {
		List<Todo> todos = todoRepository.findAll();
		
		assertNotNull(todos);
		assertEquals(2, todos.size());
		
	}

}
