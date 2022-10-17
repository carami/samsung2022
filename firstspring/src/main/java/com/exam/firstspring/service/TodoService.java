package com.exam.firstspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.firstspring.dao.TodoDao;
import com.exam.firstspring.domain.Todo;

@Service
public class TodoService {
	@Autowired
	private TodoDao todoDao = null;
	
	public TodoService(TodoDao todoDao) {
		this.todoDao = todoDao;
	}
	
//	public void setTodoDao(TodoDao todDao) {
//		this.todoDao = todDao;
//	}
//	
	
	public void findTodo() {
		todoDao.findTodo(1L);
	}
	
	public void addTodo() {
		
		todoDao.addTodo(new Todo("test"));
		
	}
	
}
