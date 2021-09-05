package com.clientservice.clientinterface.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.clientservice.clientinterface.configuration.Configuration;
import com.clientservice.clientinterface.postResponse.LoginUser;

import UsersResponse.MlRequest;
import UsersResponse.MlResponse;
import UsersResponse.User;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ClientController {
	
	RestTemplate rt = new RestTemplate();
	
	@Autowired
	private Configuration config;
	
	private boolean isUserAuthenticated;
	
	@GetMapping("/testClient")
	public String test() {
		System.out.println(config.getMlmodel());
		System.out.println(config.getChatloginAPI());
		// String response = rt.getForObject(config.getMlmodel() +"/test", String.class);
		return "test";
	}
	
	@PostMapping("/getSimilarQuote")
	public MlResponse getPredictions(@RequestBody MlRequest request) {
		ResponseEntity<MlResponse> mlModel = rt.postForEntity(config.getMlmodel() + "/getSimilarQuote", request, MlResponse.class);
		MlResponse response = mlModel.getBody();
		return response;
	}
	
	@GetMapping("/getUsers")
	public User[] getAllUsers() {
		ResponseEntity<User[]> allUsers = rt.getForEntity(config.getMlmodel()+"/array", User[].class);
		User[] test = allUsers.getBody();
		return test;
	}
	
	@PostMapping("/loginUser")
	public Boolean loginUser(@RequestBody LoginUser user) {
		ResponseEntity<String> loginServiceResponse = rt.postForEntity(config.getChatloginAPI()+"/login", user, String.class);
		String response = loginServiceResponse.getBody();
		if (response.equals("true")) {
			this.isUserAuthenticated = true;
		} else {
			this.isUserAuthenticated = false;
		}
		return this.isUserAuthenticated;
	}
	
	
}
