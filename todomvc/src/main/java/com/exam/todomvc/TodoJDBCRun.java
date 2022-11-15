package com.exam.todomvc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.todomvc.config.ApplicationConfig;
import com.exam.todomvc.dao.TodoDao;
import com.exam.todomvc.domain.Todo;

public class TodoJDBCRun {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoDao dao = ctx.getBean(TodoDao.class);
		
		List<Todo> todos =	dao.getTodos();
		
		for (Todo todo : todos) {
			System.out.println(todo);
		}
		
		DataSource ds = ctx.getBean(DataSource.class);
		System.out.println(ds);
	}

}
