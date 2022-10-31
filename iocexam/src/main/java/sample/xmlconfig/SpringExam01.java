package sample.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.MyBean;

public class SpringExam01 {

	public static void main(String[] args) {
//		MyBean myBean = new MyBean();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("exam01.xml");
		
		MyBean bean1 = (MyBean)context.getBean("myBean");
		bean1.setName("kang");
		
		System.out.println(bean1.getName());
		
		MyBean bean2 = context.getBean("myBean",MyBean.class);
		bean2.setName("kim");
		
		System.out.println(bean2.getName());
		
		if(bean1 == bean2)
			System.out.println("같아요^^");
		
		
		System.out.println(bean1.getName());
		
		MyBean bean3 = context.getBean("myBean2",MyBean.class);
		
		if (bean2 == bean3){
			System.out.println("같아요");
		}else
			System.out.println("달라요@!@@");
		
	}

}
