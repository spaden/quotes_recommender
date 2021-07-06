package com.example.chatlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.chatlogin.LoginUsers;
import com.example.chatlogin.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@PostMapping("/login")
	public String checkAndLoginUser(@RequestBody LoginUsers user) {
		LoginUsers response = service.checkAuthenticated(user.getName(), user.getPassword());
		if (response !=null) {
			return "Exists";
		}else {
			return "Not Exists";
		}
	}
}