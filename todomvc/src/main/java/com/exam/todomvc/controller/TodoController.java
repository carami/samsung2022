package com.exam.todomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/update")
	public String updateDone(@RequestParam("id") Long id) {
		todoService.updateTodo(id);
		return "redirect:list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		todoService.removeTodo(id);
		return "redirect:list";
	}
	
	@PostMapping("/add")
	public String add(@RequestParam("todo") String todo) {
		todoService.addTodo(todo);
		return  "redirect:list";
	}
}
