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
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("dataSource")
	DataSource dataSource;
	
	
	SimpleJdbcInsert simpleJdbcInsert;
	
	
	@PostConstruct
	public void init() {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("todo").usingGeneratedKeyColumns("id");
	}
	
	@Transactional
	public Todo addTodo(String todo) {
		Map<String , Object> parm = new HashMap<String, Object>();
		parm.put("todo", todo);
		parm.put("done", false);
		
		Number pk =  simpleJdbcInsert.executeAndReturnKey(parm);
		
		Todo todoobj = new Todo();
		todoobj.setId(pk.longValue());
		todoobj.setTodo(todo);
		
		return todoobj;
	}
	@Transactional(readOnly = true)
	public List<Todo> getTodos(){
		String sql = "select id, todo, done from todo order by id desc";
		return  jdbcTemplate.query(sql, new BeanPropertyRowMapper(Todo.class));		
	}
	@Transactional
	public int deleteTodo(Long id) {
		int resultCount = 0; 
		String sql = "delete from todo where id = ?";
		resultCount =  jdbcTemplate.update(sql,id);
		return resultCount;
	}
	
	 @Transactional
	    public int updateTodo(Todo todo){
	        int updateCount = 0;
	        String sql = "update todo set done = ? where id = ?";
	        updateCount = jdbcTemplate.update(sql, todo.isDone(), todo.getId() );

	        return updateCount;
	    }

	 
	    @Transactional(readOnly = true)
	    public Todo getTodo(Long id){
	        String sql = "select id, todo, done from todo where id = ?";

	        Todo todo = jdbcTemplate.queryForObject(sql, new TodoMapper(), id);

	        return todo;
	    }
	    
	    public static class TodoMapper implements RowMapper<Todo> {
	        public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Todo todo = new Todo();

	            todo.setId(rs.getLong("id"));
	            todo.setTodo(rs.getString("todo"));
	            todo.setDone(rs.getBoolean("done"));

	            return todo;
	        }
	    }
}
