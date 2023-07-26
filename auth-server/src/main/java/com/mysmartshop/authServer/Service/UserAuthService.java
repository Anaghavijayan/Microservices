package com.mysmartshop.authServer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysmartshop.authServer.dto.UserCredentials;
import com.mysmartshop.authServer.exception.InvalidCredentialsException;
import com.mysmartshop.authServer.model.User;
import com.mysmartshop.authServer.Repository.UserRepo;
import com.mysmartshop.authServer.util.Jwtutil;

@Service
public class UserAuthService {

	@Autowired
	private UserRepo repo;

	@Autowired
	private Jwtutil jwtUtil;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	public String validateUserCredentials(UserCredentials user) {
		String username = user.getUsername();
		String password = user.getPassword();

		User usr = repo.findByUsername(username);

		if (usr == null)
			throw new InvalidCredentialsException("Invalid username or password");

		String pass = usr.getPassword();
		if (!passwordEncoder.matches(password,usr.getPassword())) {

			throw new InvalidCredentialsException("Invalid username or password");

		}

		String jwt = jwtUtil.generateToken(username);
		return jwt;

	}

}
