package com.exam.todojpa.service;

import java.util.List;

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
		
	@Transactional(readOnly = true)
	public List<Todo> getTodos(){
		return todoRepository.findAll();
	}
	@Transactional
	public Todo addTodo(String todo) {
		Todo inserttodo = new Todo();
		inserttodo.setTodo(todo);
		inserttodo.setDone(false);
		return todoRepository.save(inserttodo);
	}
	 @Transactional(readOnly = true)
	    public Todo getToto(Long id) {
	        return todoRepository.findById(id).get();
	    }
}
