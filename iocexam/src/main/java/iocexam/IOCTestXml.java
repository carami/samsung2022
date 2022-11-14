package iocexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.Game;

public class IOCTestXml {

	public static void main(String[] args) {
		System.out.println("ApplicationContext 생성전!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("diceplayer.xml");
		System.out.println("ApplicationContext 생성후!!");
//		Dice dice = context.getBean(Dice.class);
//		
//		System.out.println(dice.getNumber());
		
		Game game = context.getBean(Game.class);
		
		game.play();
	}

}
