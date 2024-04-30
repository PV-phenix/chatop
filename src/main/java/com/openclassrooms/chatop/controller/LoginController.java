package com.openclassrooms.chatop.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.chatop.model.DBUser;
import com.openclassrooms.chatop.service.CustomUserDetailsService;
import com.openclassrooms.chatop.service.DBUserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
	
    @Autowired
    private DBUserService dbUserService;
    
    private static final Logger myLogger = LoggerFactory.getLogger(CustomUserDetailsService.class);
	
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
		
		return "<h3 th:inline=\"text\">C'est l'accueil</h3>";
	}


	@GetMapping("/api/auth/me")
	public String getAuthMe() {
		
		return "<h3 th:inline=\"text\">Welcome</h3>";
	}

	
	
//	@PostMapping ("/api/auth/register")
//	public DBUser saveUser(@Validated @RequestBody DBUser dbUser){
//		return dbUserService.save(dbUser);
//	}
	
    @GetMapping("/api/auth/register")
    public String registerUserAccount(@Validated DBUser dbUser,  HttpServletRequest request) {
        myLogger.debug("Registering user account with information: {}", dbUser);
        
        dbUser.setEmail("test.test.fr");
        dbUser.setCreated_at(LocalDateTime.now());
        dbUser.setUpdated_at(LocalDateTime.now());
        dbUser.setName("test");
        dbUser.setRole("USER");
        dbUser.setPassword(BCrypt.hashpw("test", BCrypt.gensalt(10) ));
                
        dbUserService.save(dbUser);
        //DBUserService.addUserLocation(registered, getClientIP(request));
        // eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
        return "success";
    }

	
	@GetMapping("/api/user/{id}")
	public DBUser getDBUserById(@PathVariable long id) {
		return dbUserService.getDBUserById(id);
	}
	
	@GetMapping("/api/users")
	public Iterable<DBUser> getDBUser( ) {
		return dbUserService.getAllDBUsers();
	}
	

}




