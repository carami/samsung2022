package iocexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import iocexam.config.DicePlayerConfig;
import iocexam.config.MyBeanConfig;
import sample.Game;
import sample.MyBean;

public class IOCJavaConfigTest2 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DicePlayerConfig.class);
		
		Game game = 	context.getBean(Game.class);
		
		game.play();
	}
	
}
