package com.chatusers.chatusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private Configuration config;
	
	@GetMapping("/test")
	public String test() {
		return config.getWelcomeMessage();
	}
	
}
