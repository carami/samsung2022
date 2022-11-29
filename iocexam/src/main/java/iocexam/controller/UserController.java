package iocexam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import iocexam.domain.User;
import iocexam.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	public void joinUser() {
		User user = new User();
		user.setName("kang");
		user.setEmail("carami@gmail.com");
		user.setPassword("1234");
		
		
		userService.joinUser(user);
	}
}
