package com.exam.todomvc.domain;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

public class Todo {
	private Long id;
	private String todo;
	private boolean done;
	@ApiModelProperty(
			name="id",
			example = "1"
	)
	@ApiParam(value = "ToDo ID", required = true)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ApiModelProperty(
			name="todo",
			example = "spring 교육듣기"
			)
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	@ApiModelProperty(
			name="done",
			example = "false"
			)
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
