package com.exam.todojpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.exam.todojpa.config.SimpleTestConfig;
import com.exam.todojpa.domain.Todo;

@SpringJUnitConfig(classes = SimpleTestConfig.class)
public class TodoServiceTest {
	@Autowired
	TodoService todoService;
	
	@Test
	void updateTodo() {
		Todo todo = todoService.updateTodo(11L);
		
		assertEquals(false, todo.isDone());
		
	}
	
	@Test
	void deleteTodo() {
		
		todoService.deleteTodo(11L);
		
		assertEquals(2, todoService.getTodos().size());
	}
}
