package com.example.demo.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoList;
import com.example.demo.repository.TodoListRepository;
import com.example.demo.service.TodolistService;

@Service
public class TodoListServiceimpl implements TodolistService{
	
	@Autowired
	private TodoListRepository todoListRepository;

	public TodoListServiceimpl(TodoListRepository todoListRepository) {
		super();
		this.todoListRepository = todoListRepository;
	}

	@Override
	public List<TodoList> getAll() {
		return todoListRepository.findAll();
	}

	@Override
	public TodoList saveTask(TodoList todoList) {
		Date date = new Date();
		todoList.setUpdatedDate(date);
		return todoListRepository.save(todoList);
	}

	@Override
	public TodoList getTaskById(Long id) {
		return todoListRepository.findById(id).orElse(null);
	}

	@Override
	public TodoList updateTask(TodoList todoList) {
		Date date = new Date();
		todoList.setUpdatedDate(date);
		return todoListRepository.saveAndFlush(todoList);
	}

	@Override
	public void deleteTaskById(Long id) {
		todoListRepository.deleteById(id);
	}

}
