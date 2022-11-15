package iocexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
//		return new UserServiceImpl(userDAO);
//	}
//	
//	@Bean UserController userController(UserService userService) {
//		UserController userController = new UserController();
//		userController.setUserService(userService);
//		return userController;
//	}

}
