package com.exam.todomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.todomvc.domain.Todo;
import com.exam.todomvc.service.TodoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/todos")
@Api(tags = "todos")
public class TodoApiController {
	
	@Autowired
	private TodoService todoService;
	
	
	@GetMapping("/bearerTest")
	public String bearerTest(@ApiIgnore @RequestHeader("Authorization") String key) {
		return key;		
	}
	
	@ApiOperation(value = "Todo 목록을 읽어온다.", notes = "전체 목록을 읽어옵니다. ")
	@ApiResponses({
		@ApiResponse(
			code = 200,
			message = "성공^^"
		)
	})
	@GetMapping
	public List<Todo> getTodos(){
		return todoService.getTodos();
	}
	
	@ApiImplicitParam(
			name="id", 
			value = "Todo 아이디", 
			required = true, 
			dataType = "String", 
			paramType = "path", 
			defaultValue = "3"
	)
	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable("id") Long id) {
		return todoService.getTodo(id);
	}
	@DeleteMapping
	public String deleteTodo(@RequestBody Todo todo) {
		todoService.deleteTodo(todo.getId());
		return "true";
	}
	
	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo.getTodo());
	}
	
	@PatchMapping
	public Todo updateTodo(@RequestBody Todo todo) {
		return todoService.updateTodo(todo.getId());
	}	
}
