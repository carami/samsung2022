package sample;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import sample.config.ApplicationConfig;
import sample.dao.TodoDao;
import sample.domain.Todo;

public class TodoJdbcRun {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		TodoDao dao = context.getBean(TodoDao.class);
		
		System.out.println(dao.getTodo(1L));
		
//		System.out.println("-----------------getTodos()----------------------");
//		List<Todo> todos = dao.getTodos();
//		for (Todo todo : todos) {
//			System.out.println(todo);
//		}
		
//		Todo updateTodo = dao.getTodo(1L);
//		updateTodo.setDone(true);
//		
//		System.out.println("update ::::::"+dao.updateTodo(updateTodo)+"건 완료!!!");
//		
//		System.out.println(dao.getTodo(1L));
//		
//		System.out.println("삭제 전:::"+dao.getTodos().size());
//		
//		System.out.println("delete :::: " + dao.deleteTodo(3L)+" 건 삭제!!");
//		
//		System.out.println("삭제 후 :::"+dao.getTodos().size());
		
		System.out.println(dao.addTodo("spring jdbc 이해하기"));
	}

}
