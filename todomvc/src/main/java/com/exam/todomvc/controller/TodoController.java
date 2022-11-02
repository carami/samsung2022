package com.exam.todomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.todomvc.domain.Todo;
import com.exam.todomvc.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Todo> todos = todoService.getTodos();
		model.addAttribute("todoList", todos);		
		return "todolist";
	}

}
