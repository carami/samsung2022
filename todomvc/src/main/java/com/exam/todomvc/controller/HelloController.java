package com.exam.todomvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/carami/hi")
	public String caramiHi(String name,Model model) {
		model.addAttribute("name",name);
		return "caramiHi";
	}
}
