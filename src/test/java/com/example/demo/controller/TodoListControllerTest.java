package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.TodoList;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TodoListControllerTest {

	 @Autowired
	 MockMvc mvc;
	 
	 @Autowired
	 private ObjectMapper mapper;
	
	 TodoList todoList;
	
	@BeforeEach
	void loadTodo() {
		 todoList = new TodoList((long) 1, "Project", true, "complete project by tomorrow");
	}
	 
	@Test
	void getTaskListTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/getTask");
		MvcResult result = mvc.perform(request).andReturn();
		List<TodoList> todos = new ArrayList<>();
		assertEquals(todos.size(), result.getResponse().getContentLength());
	}
	
	
	@Test
	void getTodoTest() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/todoList/getTask");
		MvcResult result = mvc.perform(request).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	void saveTodoTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/todoList/saveTask")
				 .contentType(MediaType.APPLICATION_JSON)
		            .content(mapper.writeValueAsString(todoList).getBytes(StandardCharsets.UTF_8))
		            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	void UpdateTodoTest() throws Exception {
		Long id = 1l;
		mvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/todoList/updateTask/{id}", id)
				 .contentType(MediaType.APPLICATION_JSON)
		            .content(mapper.writeValueAsString(todoList).getBytes(StandardCharsets.UTF_8))
		            .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	

	@Test
	void removeTodoTest() throws Exception {
		Long id = 1l;
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/todoList/removeTask/{id}", id);
		MvcResult result = mvc.perform(request).andReturn();
		assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	void GetTaskByID() throws Exception {
		Long id = 1l;
		mvc.perform(MockMvcRequestBuilders.put("http://localhost:8080/todoList/getTaskById/{id}", id)
				 .contentType(MediaType.APPLICATION_JSON)
		            .content(mapper.writeValueAsString(todoList).getBytes(StandardCharsets.UTF_8))
		            .accept(MediaType.APPLICATION_JSON));
	}

}
