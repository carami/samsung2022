package com.exam.todomvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.exam.todomvc.domain.Todo;

@Repository
public class TodoDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("dataSource")
	DataSource dataSource;
	
	private SimpleJdbcInsert simpleJdbcInsert;
	
	@PostConstruct
	public void init() {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("todos").usingGeneratedKeyColumns("id");
	}
	
	@Transactional
	public Todo addTodo(String todo) {
		Map<String, Object> params = new HashMap<>();
		params.put("todo", todo);
		params.put("done", false);
		
		Number pk = simpleJdbcInsert.executeAndReturnKey(params);
		
		Todo resultTodo = new Todo();
		resultTodo.setId(pk.longValue());
		resultTodo.setTodo(todo);
		resultTodo.setDone(false);
		
		return resultTodo;
		
	}
	
	@Transactional(readOnly = true)
	public List<Todo> getTodos(){
		String sql = "select id, todo, done from todos";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Todo.class));
	}
	
	@Transactional(readOnly =  true)
	public Todo getTodo(Long id) {
		String sql = "select id, todo,done from todos where id = ?";
		return jdbcTemplate.queryForObject(sql, new TodoMapper(),id);
	}
	
	@Transactional
	public int updateTodo(Todo todo) {
		String sql = "update todos set done = ? where id = ?";
		return jdbcTemplate.update(sql,todo.isDone(), todo.getId());
	}
	
	@Transactional
	public int deleteTodo(Long id) {
		String sql ="delete from todos where id = ?";
		return jdbcTemplate.update(sql,id);
	}
	
	public static class TodoMapper implements RowMapper<Todo>{

		@Override
		public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Todo todo = new Todo();
			
			todo.setId(rs.getLong("id"));
			todo.setTodo(rs.getString("todo"));
			todo.setDone(rs.getBoolean("done"));
			
			return todo;
		}
		
	}
}
