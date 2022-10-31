package sample.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.Dice;
import sample.Game;
import sample.MyBean;

public class SpringExam03 {

	public static void main(String[] args) {
//		MyBean myBean = new MyBean();
		
		System.out.println("ApplicationContext 생성 전!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("diceplayer.xml");
		System.out.println("ApplicationContext 생성 후!!");
//		Dice dice = context.getBean("dice",Dice.class);
//		
//		System.out.println(dice.getNumber());
		
		
		Game game = context.getBean(Game.class);		
		game.play();
	}

}
