package com.exam.todojpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;
import com.exam.todojpa.service.TodoService;

public class JpaRun {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoRepository todoRepo = ctx.getBean(TodoRepository.class);
		
		//1. 1건 저장 
//		Todo todo = new Todo();
//		todo.setTodo("쉬기!!");  //비영속 
//		
//		todo = todoRepo.save(todo);  
//		System.out.println(todo);
		
		for(int i = 0; i < 50; i++) {
			Todo todo = new Todo();
			todo.setTodo("hello "+i);
			todoRepo.save(todo);
		}
		
		//2. 조회
//		Todo resultTodo = 	todoRepo.findById(367L).orElseThrow();
//		System.out.println(resultTodo);
		
		//3. 수정 
		TodoService todoService = ctx.getBean(TodoService.class);
//		System.out.println("todoService 시작");
//		Todo todoResult2 =todoService.updateTodo(367L);
//		System.out.println("todoService 종료!!");
//		System.out.println(todoResult2);
		
		//4. 삭제
		todoService.deleteTodo(38L);
		
	}

}
