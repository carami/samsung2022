package sample.xmlconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.MyBean;

public class SpringExam02 {

	public static void main(String[] args) {
		System.out.println("ApplicationContext 생성전!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("exam02.xml");
		System.out.println("ApplicationContext 생성후!!");
		
		MyBean bean = context.getBean("bean1",MyBean.class);
		
		System.out.println(bean.getName());
		System.out.println(bean.getCount());
		
		MyBean bean2 = context.getBean("bean2",MyBean.class);

		System.out.println(bean2.getName());
		System.out.println(bean2.getCount());
		
		
		MyBean bean3 = context.getBean("bean3",MyBean.class);
		
		System.out.println(bean3.getValue("a1"));
		System.out.println(bean3.getValue("b1"));
		
		
	}

}
