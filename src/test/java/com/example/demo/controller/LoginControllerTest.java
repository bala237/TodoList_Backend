package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

	 @Autowired
	 MockMvc mvc;
	
	
	@Test
	void getUserLoginTest() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/todoList/login");
		HttpHeaders header = new HttpHeaders();
		header.add("userName", "test");
		header.add("password", "pwd123");
		request.headers(header);
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("true", result.getResponse().getContentAsString());
	}
	
	@Test
	void getUserLoginTestForFalse() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("http://localhost:8080/todoList/login");
		HttpHeaders header = new HttpHeaders();
		header.add("userName", "test");
		header.add("password", "pwd");
		request.headers(header);
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("false", result.getResponse().getContentAsString());
	}
}
