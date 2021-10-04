package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "todoList")
public class TodoList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "task")
	private String task;
	@Column(name = "updatedDate")
	private Date updatedDate;
	@Column(name = "description")
	private String description;
	
	
	public TodoList() {
		super();
	}

	public TodoList(Long id,String task, Date updatedDate, String description) {
		super();
		this.id = id;
		this.task = task;
		this.updatedDate = updatedDate;
		this.description = description;
	}

	public TodoList(long l, String string, boolean b, String string2) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TodoList [id=" + id + ", task=" + task + ", updatedDate=" + updatedDate + ", description=" + description
				+ "]";
	}

}
