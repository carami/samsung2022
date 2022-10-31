package sample.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import iocexam.controller.UserController;
import sample.Dice;
import sample.Game;
import sample.MyBean;

public class SpringExam02 {

	public static void main(String[] args) {
//		MyBean myBean = new MyBean();
		
		System.out.println("ApplicationContext 생성 전!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("userConfig.xml");
		System.out.println("ApplicationContext 생성 후!!");
//		Dice dice = context.getBean("dice",Dice.class);
//		
//		System.out.println(dice.getNumber());
		
		
		UserController controller = context.getBean(UserController.class);		
		controller.joinUser();
	}

}
