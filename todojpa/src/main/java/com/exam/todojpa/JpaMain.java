package com.exam.todojpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.repository.TodoRepository;
import com.exam.todojpa.service.TodoService;

public class JpaMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new  AnnotationConfigApplicationContext(ApplicationConfig.class);
		TodoRepository todoRepo = ctx.getBean(TodoRepository.class);
		TodoService todoService = ctx.getBean(TodoService.class);
		//1. 저장  
		
//		Todo todo = new Todo();
//		todo.setTodo("물마시기");
//		todo.setDone(false);
		
//		for(int i = 0; i<50; i++) {
//			Todo todo = new Todo();
//			todo.setTodo("hello" +i);
//			todoRepo.save(todo);
////			
//		}
//		
//		todo = todoRepo.save(todo);
//		System.out.println(todo);
		
		//2. 조회 id에 해당하는 Todo 조회 
//		Todo findTodo =  todoRepo.findById(8L).orElseThrow();
//		System.out.println(findTodo);
//		
		//3. 수정!! 
		
//		System.out.println("todoService 시작");
//		Todo resultTodo = todoService.updateTodo(8L);
//		System.out.println("todo service 끝!! ");
		
		//4. 삭제 
//		todoService.removeTodo(8L);
		
		//5. 모두 조회 
		
//		List<Todo> todos = 	todoRepo.findAll();
//		System.out.println(todos.size());
//		
//		Pageable pageable = PageRequest.of(0, 10,Sort.by("id"));
//		Page<Todo> page =    todoRepo.findAll(pageable);
//		List<Todo> todos2 = 	page.getContent();
//		System.out.println(todos2.size());
//		
//		
		//6. 할일을 이용해서 정보를 가져오고 싶다. 
//		List<Todo> result1 = todoRepo.findByTodo("hello1");
//		System.out.println(result1.size());
//		
//		
//		List<Todo> result2 = todoRepo.findByTodoStartingWith("h");
//		System.out.println(result2.size());
//		
//		
//		
		//7. jpql 을 이용해서~~ 
		List<Todo> result3 = todoRepo.findTodos("물");
		System.out.println(result3.size());
		
	}

}
