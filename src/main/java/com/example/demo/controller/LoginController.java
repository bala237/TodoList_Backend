package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.LoginService;

@RestController
@RequestMapping("/todoList")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	
	@GetMapping("/login")
	public Boolean verifyLogin(@RequestHeader String username, @RequestHeader String password) {
		return loginService.verifyUserLogin(username, password);
	}
}
