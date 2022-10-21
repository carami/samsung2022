package com.exam.todojpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.todojpa.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByTodo(String todo);
	List<Todo> findByTodoStartingWith(String todo);
	
	@Query("select t from Todo t where t.todo like %:todo%")
	List<Todo>  findTodos(@Param("todo") String todo);
	
	@Query(value="select t.id as id, t.todo as todo, t.done as done from todo t where t.todo like %:todo%", nativeQuery=true)
	List<Todo> findTodos2(@Param("todo") String todo, Pageable pageable);
}
