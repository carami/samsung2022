package iocexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import iocexam.config.UserConfig;
import iocexam.controller.UserController;
import sample.Game;
import sample.MyBean;
import sample.config.DicePlayerConfig;
import sample.config.MyBeanConfig;

public class IOCJavaConfigTest2 {
	public static void main(String[] args) {
		
		System.out.println("before");
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		System.out.println("after");
		UserController controller = context.getBean(UserController.class);
		controller.joinUser();
		
//		MyBean bean = context.getBean(MyBean.class);
		
	}
	
}
