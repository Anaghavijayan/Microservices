package com.mysmartshop.authServer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysmartshop.authServer.model.User;

public interface UserRepo extends JpaRepository <User,String>{
	
	public User findByUsername(String username);

}
