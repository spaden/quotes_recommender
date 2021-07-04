package com.chatusers.chatusers;

public class User {
	private String name;
	private Boolean available;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public User(String name, Boolean available) {
		super();
		this.name = name;
		this.available = available;
	}
	
	
}
