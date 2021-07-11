package com.example.chatlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chatlogin.table.LoginUsers;
import com.example.chatlogin.table.LoginUsersRepository;


@Service
public class LoginService {
	
	@Autowired
	private LoginUsersRepository repository;
	
	public LoginUsers checkAuthenticated(String name, String password) {
		return this.repository.checkIfExists(name, password);
	}
}
