package com.exam.todojpa.service;

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
		System.out.println("update 시작!!");
		Todo result = null;
		try {
			result = todoRepository.findById(id).orElseThrow();
			result.setDone(!result.isDone());
		}finally {
			System.out.println("update 끝!!");
		}
		return result;
	}
	@Transactional
	public void removeTodo(Long id) {
		Todo result = todoRepository.findById(id).get();
		todoRepository.delete(result);
	}
		

}
