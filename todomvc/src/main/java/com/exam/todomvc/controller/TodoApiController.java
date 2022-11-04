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
	public String bearerTest(@ApiIgnore @RequestHeader("Authorization") String authorization) {
		
		return authorization;
	}
	
	@ApiOperation(value = "todo 목록을 읽어온다.")
	@ApiResponses({
		@ApiResponse(
				code = 200,
				message = "성공입니다~~^^"
		)
	})
	@GetMapping
	public List<Todo> getTodos(){
		return todoService.getTodos();
	}
	@ApiOperation(value = "id에 해당하는 Todo를 읽어온다.", notes = "id에 해당하는 Todo를 읽어온다.")
	@ApiImplicitParam(name = "id", value = "Todo 아이디", required = true, dataType = "String", paramType = "path", defaultValue = "3")
	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable(name="id") Long id) {
		return todoService.getTodo(id);
	}
	
	@DeleteMapping
	public String deleteTodo(@RequestBody Todo todo) {
		todoService.removeTodo(todo.getId());
		return "true";
	}
	
	@PatchMapping
	public String updateTodo(@RequestBody Todo todo) {
		todoService.updateTodo(todo.getId());
		return "true";
	}
	
	@PostMapping
	public Todo addTodo(@RequestBody Todo todo) {
		return todoService.addTodo(todo.getTodo());
	}
}
