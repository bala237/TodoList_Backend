package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Response;
import com.example.demo.model.TodoList;
import com.example.demo.service.TodolistService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("/todoList")
public class TodoListController {
	
	@Autowired
	public TodolistService todolistService;

	public TodoListController(TodolistService todolistService) {
		super();
		this.todolistService = todolistService;
	}
	
	@GetMapping("/getTask")
	public List<TodoList> listTasks() {
		return todolistService.getAll();
	}
	
	@PostMapping("/saveTask")
	public ResponseEntity<Response> saveTodo(@RequestBody @NotNull TodoList todoList) {
		todolistService.saveTask(todoList);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getTaskById/{id}")
	public TodoList getTask(@PathVariable Long id) {
		return todolistService.getTaskById(id);
	}
	
	@PutMapping("/updateTask/{id}")
	public ResponseEntity<Response> updateTodo(@RequestBody @NotNull TodoList todoList,
			@PathVariable long id) {
		
		todoList.setId(id);
		todolistService.updateTask(todoList);
		return new ResponseEntity<>(HttpStatus.OK);		
	}
	
	@DeleteMapping("/removeTask/{id}")
	public ResponseEntity<Response> removeTask(@PathVariable Long id) {
		todolistService.deleteTaskById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
