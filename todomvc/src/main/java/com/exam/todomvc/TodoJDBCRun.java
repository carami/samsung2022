package com.exam.todomvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.todomvc.config.ApplicationConfig;
import com.exam.todomvc.dao.TodoDao;
import com.exam.todomvc.domain.Todo;

public class TodoJDBCRun {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoDao dao = ctx.getBean(TodoDao.class);
		
//		List<Todo> todos =	dao.getTodos();
//		
//		for (Todo todo : todos) {
//			System.out.println(todo);
//		}
//		
//		DataSource ds = ctx.getBean(DataSource.class);
//		System.out.println(ds);
//		
//		System.out.println(dao.getTodo(2l));
//		Todo todo = new Todo();
//		todo.setId(2l);
//		todo.setDone(true);
//		int count = dao.updateTodo(todo);
//		System.out.println(count);
//		System.out.println(dao.getTodo(2L));
		
		System.out.println(dao.deleteTodo(2L));
		
	}

}
