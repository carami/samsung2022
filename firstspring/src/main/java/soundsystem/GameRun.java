package soundsystem;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameRun {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("exam02.xml");
		
		Game game = ac.getBean(Game.class);
		game.play();
		
	}

}
