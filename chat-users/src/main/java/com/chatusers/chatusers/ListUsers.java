package com.chatusers.chatusers;

import java.util.ArrayList;

public class ListUsers {
  
	ArrayList<User> allUsers = new ArrayList<User>();
	
	public ListUsers() {
		for (int i=1; i < 10; i++) {
			String userName = "Max " + i;
			Boolean available = i%2 == 0 ? true: false;
			User newUser = new User(userName, available);
			this.allUsers.add(newUser);
		}
	}
	
	public ArrayList<User> test() {
		return this.allUsers;
	}
}
