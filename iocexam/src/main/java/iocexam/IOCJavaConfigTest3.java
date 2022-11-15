package iocexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.Game;
import sample.MyBean;
import sample.config.DicePlayerConfig;
import sample.config.MyBeanConfig;

public class IOCJavaConfigTest3 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DicePlayerConfig.class);
		
		Game game = 	context.getBean(Game.class);
		
		game.play();
	}
	
}
