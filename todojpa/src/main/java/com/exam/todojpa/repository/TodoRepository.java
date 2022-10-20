package com.exam.todojpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.todojpa.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
	List<Todo> findByTodo(String todo);
	List<Todo> findByTodoStartingWith(String todo);
	
	@Query("select t from Todo t where t.todo like %:todo%")
	List<Todo>  findTodos(@Param("todo") String todo);
}
