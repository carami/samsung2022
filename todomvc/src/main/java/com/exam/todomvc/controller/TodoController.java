package com.exam.todomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.todomvc.domain.Todo;
import com.exam.todomvc.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/list")
	public String getTodos(Model model) {
		
		List<Todo> todos =	todoService.getTodos();
		model.addAttribute("todoList",todos);
		return "list";
	}
	
	@PostMapping("/add")
	public String addTodo(@RequestParam("todo") String todo) {
		todoService.addTodo(todo);
		return "redirect:/list";
	}
}
