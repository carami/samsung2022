package iocexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iocexam.controller.UserController;

public class IOCUserXMLTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("exam02.xml");
		
		UserController controller = context.getBean(UserController.class);
		
		controller.joinUser();

	}

}
