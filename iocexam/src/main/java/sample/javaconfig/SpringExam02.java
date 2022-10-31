package sample.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.Dice;
import sample.MyBean;
import sample.config.DicePlayerConfig;
import sample.config.MyBeanConfig;

public class SpringExam02 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DicePlayerConfig.class);
		
		Dice dice = context.getBean(Dice.class);
		
		System.out.println(dice.getNumber());
		
		
	}

}
