package com.openclassrooms.chatop.controller;

import com.openclassrooms.chatop.model.User;
import com.openclassrooms.chatop.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
    @Autowired
    private UserService userService;


    @GetMapping("/user")
	public String getUser() {
		return "Bienvenue, User";
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Bienvenue, Admin";
	}
	
	@GetMapping("/")
	public String getLoginSuccess() {
		
		return "register";//"<h3 th:inline=\"text\">C'est l'accueil</h3>";
	}


	@GetMapping("/api/user/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/api/users")
	public Iterable<User> getUsers( ) {
		return userService.getAllUsers();
	}

}




