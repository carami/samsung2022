package com.exam.todojpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;

@Service
public class TodoService {
	@Autowired
	private TodoRepository todoRepository;
	@Transactional
	public Todo updateTodo(Long id) {
		System.out.println("TodoService    updateTodo() 시작!! ");
		Todo result = null;
		try {
			result = todoRepository.findById(id).orElseThrow();
			result.setDone(!result.isDone());
		}finally {
			System.out.println("TodoService    updateTodo() 끝!! ");
		}
		return result;
	}
	
	@Transactional
	public void deleteTodo(Long id) {
		Optional<Todo> result = todoRepository.findById(id);
		if(result.isEmpty())
			return;
		todoRepository.delete(result.get());
	}
}
