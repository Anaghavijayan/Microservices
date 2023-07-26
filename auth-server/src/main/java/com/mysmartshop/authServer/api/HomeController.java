package com.mysmartshop.authServer.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/message")
	public String greet() {
		return "hello from us";
	}
	@GetMapping("/admin")
	public String greetAdmin() {
		return "Hello Admin";
	}
	@GetMapping("/user")
	public String greetUser() {
		return "Hello User";
	}

}
