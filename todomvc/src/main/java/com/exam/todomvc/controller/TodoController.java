package com.exam.todomvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.todomvc.domain.Todo;
import com.exam.todomvc.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@PostMapping("/addToDo")
	public String addTodo(@RequestParam("todo")String todo) {
		todoService.addTodo(todo);
		
		return "redirect:./list";
	}
	
	@GetMapping("/list")
	public String getTodos(Model model) {
		//서비스에서 얻어온 정보를 모델에 넣어준다. 
		List<Todo> todos = todoService.getTodos();
		model.addAttribute("todos", todos);
		return "list";	
		
	}
	
	@GetMapping("/updateTodo")
	public String updateForm(@RequestParam("id") Long id,Model model) {
		Todo todo = todoService.getToto(id);
		model.addAttribute("todo",todo);
		return "updateTodo";
	}
	@PostMapping("/updateTodo")
	public String updateTodo(@ModelAttribute Todo todo) {
		System.out.println(todo.getTodo());
		
		return "redirect:./list";
	}
	
	 @GetMapping("/updateDone")
	    public String updateDone(@RequestParam("id") Long id){
	    	todoService.updateTodo(id);
	        return "redirect:./list"; // 자동 이동.
	    }
	    
	    @GetMapping("/deleteTodo")
	    public String deleteTodo(@RequestParam("id") Long id){
	    	todoService.removeTodo(id);
	        return "redirect:./list"; // 자동 이동.
	    }
}
