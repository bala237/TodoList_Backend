package com.example.demo.model;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Response {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseModel [message=" + message + "]";
	}
}
