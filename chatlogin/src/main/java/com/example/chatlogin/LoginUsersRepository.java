package com.example.chatlogin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginUsersRepository extends JpaRepository<LoginUsers, Integer> {
	
	 @Query("SELECT u FROM LoginUsers u WHERE u.name = ?1 and u.password = ?2")
	 LoginUsers checkIfExists(String name, String password);
}
