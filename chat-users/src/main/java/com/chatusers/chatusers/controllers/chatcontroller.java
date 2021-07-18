package com.chatusers.chatusers.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatusers.chatusers.configuration.Configuration;
import com.chatusers.chatusers.utils.ListUsers;
import com.chatusers.chatusers.utils.User;

@RestController
public class chatcontroller {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/test")
	public String test() {
		return config.getWelcomeMessage();
	}
	
	@GetMapping("/array")
	public ArrayList<User> testing() {
		ListUsers users = new ListUsers();
		return users.getAllUsers();
	}
	
	
}
