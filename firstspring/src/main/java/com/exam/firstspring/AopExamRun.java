package com.exam.firstspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.exam.firstspring.service.TodoService;

public class AopExamRun {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("sample/config/applicationContext.xml");
		
		TodoService service = ac.getBean(TodoService.class);
		service.findTodo();
		service.addTodo();
	}

}
