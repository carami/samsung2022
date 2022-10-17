package com.exam.firstspring.domain;

public class Todo {
	private Long id;
	private String todo;
	private boolean done;
	
	public Todo() {
		
	}
	public Todo(String todo) {
		this.todo = todo;
		this.done = false;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
