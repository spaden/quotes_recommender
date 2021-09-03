package com.clientservice.clientinterface.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("client-service")
public class Configuration {
	private String mlmodel;
	private String chatloginAPI;

	public String getMlmodel() {
		return mlmodel;
	}
	public void setMlmodel(String mlmodel) {
		this.mlmodel = mlmodel;
	}
	public String getChatloginAPI() {
		return chatloginAPI;
	}
	public void setChatloginAPI(String chatloginAPI) {
		this.chatloginAPI = chatloginAPI;
	}
	
	
}
