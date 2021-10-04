package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TodoList;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {

}
