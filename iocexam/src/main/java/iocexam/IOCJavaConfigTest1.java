package iocexam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.MyBean;
import sample.config.MyBeanConfig;

public class IOCJavaConfigTest1 {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		//spring 은 기본적으로 객체를 싱글턴으로 관라한다.!!!
		MyBean bean = (MyBean)context.getBean("bean1");   //DL  
		
		MyBean bean2 = context.getBean("bean2",MyBean.class);
		
		MyBean bean3 = (MyBean) context.getBean("bean1",MyBean.class);
		if(bean == bean3)
			System.out.println("bean == bean3");
		
		bean.setName("kang");
		bean2.setCount(100);
		
		if(bean == bean2)
			System.out.println("같아요!!!");
		
		
		System.out.println(bean.getName());
		System.out.println(bean2.getCount());
		System.out.println(bean2.getName());
	}
	
}
