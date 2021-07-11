package com.clientservice.clientinterface.postResponse;

public class LoginUser {
	
	private int id;

	private String name;
	
	private String password;
	
	public LoginUser(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
