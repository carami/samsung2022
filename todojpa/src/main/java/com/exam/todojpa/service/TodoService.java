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
	
	
	
	@Transactional(readOnly = true)
	public List<Todo> getTodos(){
		return todoRepository.findAll();
	}
	@Transactional
	public Todo addTodo(String todo) {
		Todo insertTodo = new Todo();
		insertTodo.setTodo(todo);
		return todoRepository.save(insertTodo);
	}
	
	@Transactional
    public Todo updateTodo(Long id){
		System.out.println("update 시작!!!");
        Todo todo =  null;
        try {
        		todo = todoRepository.findById(id).orElseThrow();
        		todo.setDone(!todo.isDone());
        }catch (Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("update 끝!!!");
		}        
        return todo;
    }

    @Transactional
    public void removeTodo(Long id){
        Optional<Todo> result = todoRepository.findById(id);
        
        todoRepository.delete(result.get());
        	
    }
    
    @Transactional(readOnly = true)
    public Todo getToto(Long id) {
        return todoRepository.findById(id).get();
    }
}
