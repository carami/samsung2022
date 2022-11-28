package sample.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.Dice;
import sample.MyBean;

public class SpringExam03 {

	public static void main(String[] args) {
		System.out.println("ApplicationContext 생성전!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("dicegame.xml");
		System.out.println("ApplicationContext 생성후!!");
		
		Dice dice = context.getBean(Dice.class);
		
		System.out.println(dice.getNumber());
		System.out.println(dice.getNumber());
		System.out.println(dice.getNumber());
		System.out.println(dice.getNumber());
		System.out.println(dice.getNumber());
		
		
	}

}
