package com.clientservice.clientinterface.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("client-service")
public class Configuration {
	private String chatusersAPI;
	private String chatloginAPI;
	
	public String getChatusersAPI() {
		return chatusersAPI;
	}

	public void setChatusersAPI(String chatusersAPI) {
		this.chatusersAPI = chatusersAPI;
	}

	public String getChatloginAPI() {
		return chatloginAPI;
	}

	public void setChatloginAPI(String chatloginAPI) {
		this.chatloginAPI = chatloginAPI;
	}
	
	
}
