package sample.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		MyBean bean1 = (MyBean)context.getBean("myBean");
		
		MyBean bean2 = context.getBean("myBean", MyBean.class);  //같은 클래스가 둘 이상 등록되면 오류 발생.. (그때는 id를 명시해준다.) 
		
		MyBean bean3 = context.getBean("myBean2", MyBean.class);
		
		if(bean1 == bean2)
			System.out.println("true");
		
		if (bean1 == bean3)
			System.out.println("true");
		else
			System.out.println("false");
		
	}

}
