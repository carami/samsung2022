package com.exam.firstspring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.firstspring.service.TodoService;

public class UserBeanRun {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.exam.firstspring.ioc.config");
		
		UserBean userBean = ac.getBean("userBean",UserBean.class);
		
		userBean.setName("kang");
		
		System.out.println(userBean.getName());
		
		TodoService service = ac.getBean(TodoService.class);
		service.addTodo();
	}

}
