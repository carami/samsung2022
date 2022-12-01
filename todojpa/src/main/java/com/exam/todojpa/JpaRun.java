package com.exam.todojpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
		
//		for(int i = 0; i < 50; i++) {
//			Todo todo = new Todo();
//			todo.setTodo("hello "+i);
//			todoRepo.save(todo);
//		}
//		
		//2.한 건 조회
//		Todo resultTodo = 	todoRepo.findById(367L).orElseThrow();
//		System.out.println(resultTodo);
		
		//3. 수정 
		TodoService todoService = ctx.getBean(TodoService.class);
//		System.out.println("todoService 시작");
//		Todo todoResult2 =todoService.updateTodo(367L);
//		System.out.println("todoService 종료!!");
//		System.out.println(todoResult2);
		
		//4. 삭제
//		todoService.deleteTodo(38L);
		
		//5. 여러건 조회
		List<Todo> todos =	null;
//		todos = 	todoRepo.findAll();
		
		Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());
//		todos =	todoRepo.findAll(pageable).getContent();
//		
//		
		
		//6. findByTodo 이용한 조회 
//		Todo result1 = 	todoRepo.findByTodo("hello 10").orElseThrow();
//		System.out.println(result1);
//		
//		todos = todoRepo.findByTodoContaining("1",pageable);
//		System.out.println(todos.size());
		
		
		//7. jqpl 
//		todos = todoRepo.findTodos("4", pageable);
		
		//8 native query
		todos = todoRepo.findTodos2("4");
		
		
		
		
		for (Todo todo : todos) {
			System.out.println(todo);
		}
		
	}

}
