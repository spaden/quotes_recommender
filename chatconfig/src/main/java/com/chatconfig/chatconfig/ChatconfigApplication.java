package com.chatconfig.chatconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ChatconfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatconfigApplication.class, args);
	}

}
