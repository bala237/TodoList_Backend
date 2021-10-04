package com.example.demo.serviceimpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TodoListRepository;
import com.example.demo.service.LoginService;

@Service
public class LoginServiceimpl implements LoginService{
	
	@Autowired
	TodoListRepository todoListRepository;
		
	List<HashMap<String,String>> loginCredentials = new ArrayList<>();
	HashMap<String,String> user = new HashMap<>();
	
	
	@Override
	public List<HashMap<String, String>> addUser() {
		user.put("test","pwd123");
		loginCredentials.add(user);
		return loginCredentials;
	}
	
	@Override
	public Boolean verifyUserLogin(String username, String password) {
		addUser();
		for(HashMap<String, String> credentials : loginCredentials) {
		if(credentials.containsKey(username) && credentials.containsValue(password)) {
			return true;
		}}
		return false;
	}
}
