package com.exam.todojpa.service;

import java.util.List;
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
		System.out.println("service  updateTodo start!! ");
		Todo todo = null;
		try {
			todo = todoRepository.findById(id).orElseThrow();
			
			todo.setDone(!todo.isDone());
		
		}finally {
			System.out.println("service  updateTodo end!!!! ");
		}
		return todo;
	}
	
	@Transactional
	public void removeTodo(Long id) {
		Optional<Todo> result =	todoRepository.findById(id);
//		if(result.isEmpty())
//			return false;
		todoRepository.delete(result.get());		
	}
	@Transactional(readOnly = true)
	public List<Todo> getTodos() {
		// TODO Auto-generated method stub
		return todoRepository.findAll();
	}
	@Transactional
	public Todo addTodo(String todo) {
		Todo todoObj = new Todo(todo);
		return todoRepository.save(todoObj);
		
	}
	
	@Transactional(readOnly = true)
	public Todo getTodo(Long id) {
		return todoRepository.findById(id).get();
	}

}
