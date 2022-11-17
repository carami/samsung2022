package com.exam.todojpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;
import com.exam.todojpa.service.TodoService;

public class TodoJapRun {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		TodoRepository todoRepository = ctx.getBean(TodoRepository.class);
		
		//1. 1건 저장하기. 
//		
//		Todo todo = new Todo("jpa 재밌쬬??!!");
//		
//		todo = todoRepository.save(todo);
//		
//		//2. id에 해당하는 todo 조회 
//		Todo findTodo = todoRepository.findById(10L).orElseThrow();
//		
//		System.out.println(findTodo);
//		
//		Todo findTodo2 = todoRepository.getById(10L);
//		System.out.println(findTodo);
		
//		//3. update 
		TodoService service = ctx.getBean(TodoService.class);
//		
//		System.out.println("todoService start");
//		Todo resultTodo1 = service.updateTodo(10L);
//		System.out.println(resultTodo1);
//		System.out.println("todoService end");
//		
		
		//4. 삭제
//		Todo findTodo2 = todoRepository.getById(10L);
//		todoRepository.delete(findTodo2);
		
		service.removeTodo(14L);
		
	}

}
