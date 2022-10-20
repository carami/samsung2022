package com.exam.todojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.service.TodoService;

@RestController
@RequestMapping("/api/todos")
public class TodoAPIController {

	@Autowired
	private TodoService todoService;
	
	
	@GetMapping
	public List<Todo> getTodos(){
		return todoService.getTodos();
	}
	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable(name="id")Long id) {
		return todoService.getToto(id);
	}

	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo.getTodo());
	}
	
	@DeleteMapping
	public String deleteTodo(@RequestBody Todo todo) {
		todoService.removeTodo(null);
		return "true";
	}
	public Todo updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo.getId());
	}
}
