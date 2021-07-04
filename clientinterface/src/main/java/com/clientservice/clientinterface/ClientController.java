package com.clientservice.clientinterface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import UsersResponse.User;

@RestController
public class ClientController {
	
	RestTemplate rt = new RestTemplate();
	
	@GetMapping("/testClient")
	public String test() {
		String response = rt.getForObject("http://localhost:8080/test", String.class);
		return response;
	}
	
	@GetMapping("/getUsers")
	public User[] getAllUsers() {
		ResponseEntity<User[]> allUsers = rt.getForEntity("http://localhost:8080/array", User[].class);
		User[] test = allUsers.getBody();
		return test;
		
	}
	
}
