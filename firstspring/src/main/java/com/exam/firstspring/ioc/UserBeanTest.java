package com.exam.firstspring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exam.firstspring.domain.Todo;
import com.exam.firstspring.service.TodoService;

public class UserBeanTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:exam01.xml");
		
		UserBean userBean =(UserBean) ac.getBean("userBean");
		userBean.setName("kang");
		
		System.out.println(userBean.getName());
		
		UserBean userBean2 = ac.getBean("userBean",UserBean.class);
		
		Todo todo = ac.getBean("todo",Todo.class);
		todo.setTodo("ioc 이해하기!!! ");
		
		System.out.println(todo.getTodo());
		
		TodoService service = ac.getBean("todoService",TodoService.class);
		service.addTodo();
	}

}
