package com.exam.firstspring.dao;

import org.springframework.stereotype.Repository;

import com.exam.firstspring.domain.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {

	@Override
	public Todo findTodo(Long id) {	
		
		System.out.println("todo를 찾아서 리턴합니다!!");
		Todo todo = new Todo("ioc!");
		return todo;
	}

	@Override
	public void addTodo(Todo todo) {
		System.out.println("todo를 저장합니다.");
		
	}
}
