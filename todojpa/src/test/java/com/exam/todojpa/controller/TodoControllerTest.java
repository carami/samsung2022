package com.exam.todojpa.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.exam.todojpa.config.ApplicationConfig;
import com.exam.todojpa.config.MvcConfig;
import com.exam.todojpa.domain.Todo;
import com.exam.todojpa.service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfig.class,ApplicationConfig.class})
public class TodoControllerTest {
	
	private final List<Todo> todos = new ArrayList<Todo>();
	
	@InjectMocks
	private TodoAPIController todoAPIController;
	
	@Mock
	private TodoService todoService;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void initTodos() {
		Todo todo = new Todo();
		todo.setId(1L);
		todo.setTodo("mock~~");
		todos.add(todo);
		
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(todoAPIController).build();
	}
	
	@Test
	public void testList() throws Exception{
		ObjectMapper objectMapper = new ObjectMapper();
		when(todoService.getTodos()).thenReturn(todos);
		
		this.mockMvc.perform(get("/api/todos"))
		.andExpect(status().isOk())
//		.andExpect(content().string(containsString(objectMapper.writeValueAsString(todos))))
		.andDo(print());
		
		verify(todoService, times(1)).getTodos();
		
		
	}

}
