package iocexam.controller;

import iocexam.domain.User;
import iocexam.service.UserService;

public class UserController {
	
	private UserService userService;
	
	public void joinUser() {
		User user = new User();
		user.setName("kang");
		user.setEmail("carami@nate.com");
		user.setPassword("1234");
		
		userService.joinUser(user);
		
	}
}
