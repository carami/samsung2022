package com.exam.todojpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exam.todojpa.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("email") String email, @RequestParam("password") String password ) {
		String encodePassword = passwordEncoder.encode(password);
		userService.addUser(email, encodePassword);
		return "redirect:/";
	}

}
