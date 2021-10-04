package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TodoList;


public interface TodolistService {
	List<TodoList> getAll();
	
	TodoList saveTask(TodoList todoList);
	TodoList getTaskById(Long id);
	TodoList updateTask(TodoList todoList);
	void deleteTaskById(Long id);
}
