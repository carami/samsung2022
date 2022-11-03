package com.exam.todojpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;

public class jpaRun {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		TodoRepository todorepo = ctx.getBean(TodoRepository.class);
		
		//1. 저장 
		
		Todo todo = new Todo();
		todo.setTodo("스트레칭하기!!");
		todo.setDone(false);
		
		todo = todorepo.save(todo);
		
		System.out.println(todo);
		
	}

}
