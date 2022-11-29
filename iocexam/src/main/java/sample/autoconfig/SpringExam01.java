package sample.autoconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.Game;
import sample.MyBean;

public class SpringExam01 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		MyBean myBean = context.getBean(MyBean.class);
		
		myBean.setName("hong");
		
		System.out.println(myBean.getName());
		
		Game game = context.getBean(Game.class);
		game.play();
	}

}
