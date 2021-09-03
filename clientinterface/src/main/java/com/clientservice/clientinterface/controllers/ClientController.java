package com.clientservice.clientinterface.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.clientservice.clientinterface.configuration.Configuration;
import com.clientservice.clientinterface.postResponse.LoginUser;

import UsersResponse.User;

@RestController
public class ClientController {
	
	RestTemplate rt = new RestTemplate();
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/testClient")
	public String test() {
		String response = rt.getForObject(config.getMlmodel() +"/test", String.class);
		return response;
	}
	
	@GetMapping("/getUsers")
	public User[] getAllUsers() {
		ResponseEntity<User[]> allUsers = rt.getForEntity(config.getMlmodel()+"/array", User[].class);
		User[] test = allUsers.getBody();
		return test;
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody LoginUser user) {
		ResponseEntity<String> loginServiceResponse = rt.postForEntity(config.getChatloginAPI()+"/login", user, String.class);
		String response = loginServiceResponse.getBody();
		return response;
	}
	
}
