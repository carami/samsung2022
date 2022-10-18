package com.exam.todomvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.exam.todomvc.domain.Todo;
@Repository
public class TodoDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Todo> getTodos(){
		String sql = "select id, todo, done from todo order by id desc";
		return  jdbcTemplate.query(sql, new BeanPropertyRowMapper(Todo.class));
		
	}
}
