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

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.config.SimpleTestConfig;
import com.exam.todojpa.domain.Todo;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(classes = {SimpleTestConfig.class, ApplicationConfig.class})
@DisplayName("TodoRepository test")
@Transactional
public class TodoRepositoryTest {
	private static Logger logger = LoggerFactory.getLogger(TodoRepository.class);
	@Autowired
	private TodoRepository todoRepository;
	
	@BeforeAll
	static void setup() {
		logger.info("----> @BeforeAll ---     이 클래스의 테스트 메서드가 실행되기 전에 한 번 실행됩니다.");		
	}
	
	@AfterAll
	static void tearDown() {
		logger.info("----> @AfterAll ---     이 클래스의 테스트 끝나기 전에 한 번 실행됩니다.");	
	}
	
	@BeforeEach
	void init() {
		logger.info("----> @BeforeEach ---     이 클래스의 테스트 각 메서드가 실행되기 전에 매번 실행됩니다.");	
	}
	@AfterEach
	void dispose() {
		logger.info("----> @AfterEach ---     이 클래스의 테스트 각 메서드가 끝날때 매번 실행됩니다.");	
	}
	
	@Test
	void test1() {
		logger.info("test1 =======================================");
	}
	
	@Test
	void test2() {
		logger.info("test2 ========================================");
	}
	
	@Test
	@SqlGroup({
		@Sql(value = "classpath:db/test-data.sql",
				config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
				executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
		@Sql(value = "classpath:db/clean-up.sql",
				config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
				executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD),
})
	void findAll(){
		logger.info("find All~~~");
		List<Todo> todos = todoRepository.findAll();
		assertNotNull(todos);
		assertEquals(6, todos.size());		
	}
	
	@Test
	@DisplayName("Todo hello 저장 테스트")
	void save() {
		logger.info("save test~~ ");
		Todo todo = new Todo();
		todo.setTodo("hello");
		
		todo =	todoRepository.save(todo);
		assertNotNull(todo.getId());
	}
}
