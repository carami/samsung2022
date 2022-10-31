package sample.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import iocexam.config.UserConfig;
import iocexam.controller.UserController;
import sample.Dice;
import sample.Game;
import sample.MyBean;
import sample.config.DicePlayerConfig;
import sample.config.MyBeanConfig;

public class SpringExam03 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		

		UserController controller = context.getBean(UserController.class);		
		controller.joinUser();
	}

}
