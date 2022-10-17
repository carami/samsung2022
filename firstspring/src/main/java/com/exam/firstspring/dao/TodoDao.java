package com.exam.firstspring.dao;

import com.exam.firstspring.domain.Todo;

public interface TodoDao {
	public Todo findTodo(Long id);
	public void addTodo(Todo todo);
}
