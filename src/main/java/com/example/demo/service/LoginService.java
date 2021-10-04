package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

public interface LoginService {
	
	List<HashMap<String,String>> addUser();
	Boolean verifyUserLogin(String username, String password);
}
