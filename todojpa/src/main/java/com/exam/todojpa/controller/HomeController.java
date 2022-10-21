package com.exam.todojpa.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.todojpa.domain.User;
import com.exam.todojpa.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Principal pricipal) {
		logger.info("pricipal : {} ", pricipal);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		logger.info("authentication.getName() : {} ", authentication.getName());
		
		if(pricipal != null) {
			User user = userService.getUser(pricipal.getName());
			
			logger.info("user : {} ", user);
		}
		
		return "home";
	}
	
}
