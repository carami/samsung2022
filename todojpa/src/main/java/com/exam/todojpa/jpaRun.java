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

public class jpaRun {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		TodoRepository todorepo = ctx.getBean(TodoRepository.class);
		
		//1. 저장 
		
//		Todo todo = new Todo();
//		todo.setTodo("스트레칭하기!!");
//		todo.setDone(false);
//		
//		todo = todorepo.save(todo);
//		
//		System.out.println(todo);
		
//		for(int i = 0; i < 20; i++) {
//			Todo todo = new Todo();
//			todo.setTodo("hello "+ i);
//			todorepo.save(todo);
//			System.out.println("-----");
//		}
//	System.out.println("==============");
		
		//2. 조회 
//		Todo result1 =	todorepo.findById(3L).orElseThrow();
//		System.out.println(result1);
//		
		
		//3. update 
//		TodoService service = ctx.getBean(TodoService.class);
//		System.out.println("todoService 시작");
//		
//		Todo result2 = 	service.updateTodo(7L);
//		System.out.println(result2);
//		
//		System.out.println("todo service 끝!! ");
		
		
		//4. delete 
//		TodoService service = ctx.getBean(TodoService.class);
//		service.removeTodo(7L);
		
		
	//5. 인터페이스에 추가한 메소드를 실행..  todo를 이용해서 검색한다. 
//		Todo result3 = todorepo.findTodoByTodo("test").get();
//		System.out.println(result3);
//		
//		//6.전체검색 
//		List<Todo> todos = todorepo.findAll();
//		
//		System.out.println(todos.size());
		
	//6. Pageable 객체를 이용해서 가져오기. 
//		Pageable pageable = PageRequest.of(3, 5, Sort.by("id").descending());
//		
//		Page<Todo> page = todorepo.findAll(pageable);
//		List<Todo> result5 = page.getContent();
//		System.out.println(result5.size());
//		for (Todo todo : result5) {
//			System.out.println(todo);
//		}
		
		//7. todoStart
//		List<Todo> list1 = todorepo.findTodoByTodoStartingWith("t");
//		List<Todo> list1 = todorepo.findTodoByIdGreaterThan(200L);
		
		Pageable pageable = PageRequest.of(0, 5, Sort.by("id").descending());
//		List<Todo> list1 = todorepo.findTodoByIdGreaterThan(200L, pageable);
		
		
		//jpql 사용!!!
//		List<Todo> list1 = todorepo.findTodos("he", pageable);
		
		//9. native query 사용
		List<Todo> list1 = todorepo.findTodos2("he", pageable);
		
		for (Todo todo : list1) {
			System.out.println(todo);
		}
		
	}

}
