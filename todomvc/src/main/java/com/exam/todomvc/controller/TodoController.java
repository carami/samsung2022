package com.exam.todomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exam.todomvc.domain.Todo;
import com.exam.todomvc.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	
	@GetMapping("list")
	public String getTodos(Model model) {
		//서비스에서 얻어온 정보를 모델에 넣어준다. 
		List<Todo> todos = todoService.getTodos();
		model.addAttribute("todos", todos);
		return "list";	
		
	}
}
