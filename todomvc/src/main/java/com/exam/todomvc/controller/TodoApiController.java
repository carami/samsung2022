package com.exam.todomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.todomvc.domain.Todo;
import com.exam.todomvc.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/todos")
@Api(tags = "todos")
public class TodoApiController {

	@Autowired
	TodoService todoService;

	@ApiOperation(value = "Todo 목록을 읽어옵니다.", notes = "todo 리스트를 구할 수 있어요^^")
	@GetMapping
	public List<Todo> getTodos() {
		return todoService.getTodos();
	}
	@ApiOperation(value = "id에 해당하는 Todo를 읽어온다.", notes = "아이디에 해당하는 Todo를 읽어옵니다.")
	@ApiImplicitParam(
			name = "id", 
			value = "Todo 아이디", 
			required = true, 
			dataType = "String", 
			paramType = "path",
			defaultValue = "3")
	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable(name = "id") Long id) {
		return todoService.getTodo(id);
	}

	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo.getTodo());
	}

	@DeleteMapping
	public String deleteTodo(@RequestBody Todo todo) {
		todoService.removeTodo(todo.getId());

		return "true";
	}

//	
	@PatchMapping
	public Todo updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo.getId());
	}

}
