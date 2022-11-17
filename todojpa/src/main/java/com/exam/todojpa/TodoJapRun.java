package com.exam.todojpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;

public class TodoJapRun {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		TodoRepository todoRepository = ctx.getBean(TodoRepository.class);
		
		//1. 1건 저장하기. 
		
		Todo todo = new Todo("jpa 재밌쬬??!!");
		
		todoRepository.save(todo);
		
	}

}
