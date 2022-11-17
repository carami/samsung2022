package com.exam.todomvc.domain;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

public class Todo {
	private Long id;
	private String todo;
	private boolean done;
	public Long getId() {
		return id;
	}
	@ApiModelProperty(
			name = "id",
			example = "1"
			)
	@ApiParam(value = "Todo ID", required = true)
	public void setId(Long id) {
		this.id = id;
	}
	@ApiModelProperty(
			name = "todo",
			example = "물마시기"
			)
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
	@Override
	public String toString() {
		return "Todo [id=" + id + ", todo=" + todo + ", done=" + done + "]";
	}	
}
