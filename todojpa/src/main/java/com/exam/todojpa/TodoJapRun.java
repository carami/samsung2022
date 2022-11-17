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
		
//		service.removeTodo(14L);
		
		//5. 모두조회  
		Pageable pageable = PageRequest.of(0, 3, Sort.by("id").descending());
//		
//		Page<Todo> page = todoRepository.findAll(pageable);
//		List<Todo> todos = page.getContent();
//		
//		for (Todo todo : todos) {
//			System.out.println(todo);
//		}
//		
		
		//6. todo로 검색하도록 내가 정의한 인터페이스를 이용해서 조회. 
//		List<Todo> todos = todoRepository.findByTodo("jpa 재밌쬬??!!");
		
//		List<Todo> todos = todoRepository.findByTodoStartingWith("jp");
		
//		List<Todo> todos = todoRepository.findByTodoStartingWith("jp", pageable);
		
		//jqpl을 이용한 메서드 실행 
//		List<Todo> todos = todoRepository.findTodos("습", pageable);
		
		//native query 를 이용한 메서드 실행
		List<Todo> todos = todoRepository.findTodos2("te");
		
		for (Todo todo : todos) {
			System.out.println(todo);
		}
	}

}
