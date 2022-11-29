package sample.javaConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.MyBean;
import sample.config.MyBeanConfig;

public class SpringExam01 {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(MyBeanConfig.class);

		// spring ioc 컨테이너는 기본적으로 객체를 싱글턴으로 관리한다.
		MyBean bean1 = (MyBean) context.getBean("bean1");
		bean1.setName("kang");

		System.out.println(bean1.getName());

		MyBean bean2 = context.getBean("bean1", MyBean.class);

		System.out.println(bean2.getName());

		if (bean1 == bean2)
			System.out.println("bean1과 bean2는 같은 객체입니다.");

		MyBean bean3 = context.getBean("bean2", MyBean.class);

		if (bean1 == bean3)
			System.out.println("bean1과 bean3는 같은 객체입니다.");
		else
			System.out.println("bean1과 bean3는 다른 객체입니다.");

		System.out.println(bean3.getName());
	}

}
