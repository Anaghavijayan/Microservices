package com.mysmartshop.authServer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysmartshop.authServer.Repository.UserRepo;
import com.mysmartshop.authServer.model.User;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepo repo;
	
	 public UserDetails loadUserByUsername(String username) {
		User user =  repo.findByUsername(username);
		return new UserDetailsModel(user);
	}
	 
	 
	
}
