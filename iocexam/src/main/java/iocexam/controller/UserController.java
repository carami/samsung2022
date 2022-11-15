package iocexam.controller;

import org.springframework.stereotype.Controller;

import iocexam.domain.User;
import iocexam.service.UserService;

@Controller
public class UserController {
	
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
//	@Autowired
//	public void setUserService(UserService userService) {
//		this.userService = userService;
//	}
	
	public void joinUser() {
		User user = new User();
		user.setName("kang");
		user.setEmail("carami@nate.com");
		user.setPassword("1234");
		
		userService.joinUser(user);
	}

}
