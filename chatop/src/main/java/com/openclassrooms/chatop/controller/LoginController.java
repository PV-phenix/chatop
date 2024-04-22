package com.openclassrooms.chatop.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
	@GetMapping("/user")
	public String getUser() {
		return "Welcome, User";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Welcome, Admin";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "<h3 th:inline=\"text\">Welcome [[${#httpServletRequest.remoteUser}]]</h3>";
	}
}
