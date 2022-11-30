package com.exam.todomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todomvc.dao.TodoDao;
import com.exam.todomvc.domain.Todo;

@Service
public class TodoService {
	
	@Autowired
	private TodoDao todoDao;
	
	@Transactional(readOnly =  true)
	public List<Todo> getTodos(){
		return todoDao.getTodos();
	}
	
	public Todo addTodo(String todo) {
		return todoDao.addTodo(todo);
		
	}

}
