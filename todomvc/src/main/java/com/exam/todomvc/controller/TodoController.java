package com.exam.todomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoController {
	@GetMapping("list")
	public String getTodos(Model model) {
		//서비스에서 얻어온 정보를 모델에 넣어준다. 
		
		return "list";	
		
	}
}
