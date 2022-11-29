package iocexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "iocexam")
public class UserConfig {
//	@Bean
//	public UserDAO userDAO() {
//		return new UserCaramiDAOImpl();
//	}
//	
//	@Bean
//	public UserService userService(UserDAO userDAO) {
//		UserServiceImpl userService = new UserServiceImpl();
//		userService.setUserDAO(userDAO);
//		return userService;
//	}
//	
//	@Bean
//	public UserController userController(UserService userService) {
//		return new UserController(userService);
//	}

}
