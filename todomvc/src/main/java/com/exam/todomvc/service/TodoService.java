package com.exam.todomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.todomvc.dao.TodoDao;
import com.exam.todomvc.domain.Todo;

@Service
public class TodoService {
	@Autowired
	private TodoDao todoDao;
	
	public List<Todo> getTodos(){
		return todoDao.getTodos();
	}
}
