package iocexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iocexam.config.UserConfig;
import iocexam.controller.UserController;

public class UserRun {

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("user.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		
		UserController userController = context.getBean(UserController.class);
		
		userController.joinUser();
		
		
	}

}
