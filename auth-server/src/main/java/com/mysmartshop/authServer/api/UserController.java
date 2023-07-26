package com.mysmartshop.authServer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysmartshop.authServer.dto.JwtToken;
import com.mysmartshop.authServer.dto.UserCredentials;
import com.mysmartshop.authServer.model.User;
import com.mysmartshop.authServer.Repository.UserRepo;
import com.mysmartshop.authServer.Service.UserAuthService;

@RestController
public class UserController {

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private UserAuthService authService;
	
	@Autowired
	AuthenticationManager authMgr;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		String password = user.getPassword();
		String encryptedPassword = passwordEncoder.encode(password);
		user.setPassword(encryptedPassword);
		repo.save(user);
		return user;
	}
	
	@PostMapping("/login")
	public JwtToken authenticate(@RequestBody UserCredentials user) {
		authMgr.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		String jwt = authService.validateUserCredentials(user);
		
		return new JwtToken(jwt);
	}
	
	
}
