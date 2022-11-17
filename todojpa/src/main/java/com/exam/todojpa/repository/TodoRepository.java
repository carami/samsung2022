package com.exam.todojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.todojpa.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
