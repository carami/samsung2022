package iocexam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import iocexam.controller.UserController;
import iocexam.dao.UserDAO;
import iocexam.dao.UserDAOImpl;
import iocexam.service.UserService;
import iocexam.service.UserServiceImpl;

@Configuration
@ComponentScan(basePackages = {"iocexam"})
public class UserConfig {
	
	
//	@Bean
//	public UserDAO userDAO() {
//		return new UserDAOImpl();
//	}
//	
//	@Bean
//	public UserService userService(UserDAO userDAO) {
//		UserService userService = new UserServiceImpl(userDAO);
//		return userService;
//	}
//	
//	@Bean
//	public UserController userController(UserService userService) {
//		UserController userController = new UserController();
//		userController.setUserService(userService);
//		return userController;
//	}

}
