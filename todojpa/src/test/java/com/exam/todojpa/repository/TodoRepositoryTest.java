package com.exam.todojpa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.config.SimpleTestConfig;
import com.exam.todojpa.domain.Todo;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig(classes = {ApplicationConfig.class,SimpleTestConfig.class})
//@DisplayName("TodoRepository 테스트!!")
@Transactional
public class TodoRepositoryTest {
	private static Logger logger = LoggerFactory.getLogger(TodoRepository.class);
	
	@Autowired
	private TodoRepository todoRepository;
	
	@BeforeAll
	static void setup() {
		logger.info("-----> @BeforeAll  ---  이 클래스의 모든 테스트 메서드를 실하기 전에 실행됩니다.");
	}
	
	@AfterAll
	static void tearDown() {
		logger.info("-----> @AfterAll  ---  이 클래스의 모든 테스트 메서드를 실행한  후에 실행됩니다.");
	}
	
	@BeforeEach
	void init() {
		logger.info("-----> @BeforeEach  ---  이 클래스의 각 테스트 메서드를 실하기 전에 실행됩니다.");
	}
	@AfterEach
	void dispose() {
		logger.info("----->@AfterEach  ---  이 클래스의 각 테스트 메서드를 생행 한 후 에 실행됩니다.");
	}
	
	@Test
	void test() {
		logger.info("------> test 실행!!!!");
	}
	
	@Test
	void test2() {
		logger.info("------> test2 실행!!!!");
	}
	
	@Test
	void findAll() {
		logger.info("------>fideAll() 실행");
		List<Todo> todos = todoRepository.findAll();
		
		assertNotNull(todos);
		assertEquals(3, todos.size());
	}
	
	@Test
	void save() {
		logger.info("save()~");
		Todo todo = new Todo("junit test 실습하기");
		todo = todoRepository.save(todo);
		assertNotNull(todo.getId());
		logger.info(todo.getId() + todo.getTodo());
		
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
	void findByTodoStartingWith() {
		List<Todo> todos =	todoRepository.findByTodoStartingWith("h");
		assertEquals(2, todos.size());
	}
}
