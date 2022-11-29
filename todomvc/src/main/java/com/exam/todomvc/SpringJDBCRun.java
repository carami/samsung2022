package com.exam.todomvc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.todomvc.config.ApplicationConfig;
import com.exam.todomvc.dao.TodoDao;
import com.exam.todomvc.domain.Todo;

public class SpringJDBCRun {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoDao dao = context.getBean(TodoDao.class);
		
		Todo rtodo = new Todo();
		rtodo.setDone(true);
		rtodo.setId(1L);
		
		dao.updateTodo(rtodo);
		
		List<Todo> todos =	dao.getTodos();
		
		for (Todo todo : todos) {
			System.out.println(todo);
		}
	}

}
