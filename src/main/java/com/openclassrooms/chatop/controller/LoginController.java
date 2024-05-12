package com.openclassrooms.chatop.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.chatop.model.DBUser;
import com.openclassrooms.chatop.service.CustomUserDetailsService;
//import com.openclassrooms.chatop.service.CustomUserDetailsService;
import com.openclassrooms.chatop.service.DBUserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
    @Autowired
    private DBUserService dbUserService;
    
    @Autowired
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
	public String getAuthMe(@Validated DBUser dbUser,  HttpServletRequest request) {
		
		return "<h3 th:inline=\"text\">Welcome</h3>";
	}

	
    @PostMapping("/api/auth/register")
    @ResponseBody
    public String afterUserCreation(@RequestBody User dbuser, HttpServletRequest request) 
    {
    	//myLogger.debug("Registering user account with information: {}", dbUser);
    	DBUser dbUser = new DBUser();
        System.out.println("start register method");
        dbUser.setName(dbuser.getName());
        //dbUser.setPassword(dbuser.getPassword());
        dbUser.setRole("USER");
        dbUser.setCreated_at(LocalDateTime.now());
        dbUser.setPassword(BCrypt.hashpw(dbuser.getPassword(), BCrypt.gensalt(10) ));
        //String Password = request.getParameter("password");
        //String ConfirmedPassword = request.getParameter("confirm_password");
        System.out.println("user: "+dbUser.getName() + " email: "+dbUser.getEmail()+" pass: "+dbUser.getPassword());
       
        dbUserService.save(dbUser);
        return "Register Success";
    }

	
	@GetMapping("/api/user/{id}")
	public DBUser getDBUserById(@PathVariable long id) {
		return dbUserService.getDBUserById(id);
	}
	
	@GetMapping("/api/users")
	public Iterable<DBUser> getDBUser( ) {
		return dbUserService.getAllDBUsers();
	}
	
	@PostMapping("/api/auth/login")
	public String UserLogin(@RequestBody User dbuser, HttpServletRequest request) throws ServletException  
	{
		System.out.println("start login method");
		
		DBUser dBUser=dbUserService.getDBUserByName(dbuser.getName());
		dBUser.setRole("USER");
		//DBUser dBUser=dbUserService.getDBUserByEmail(request.getParameter("email"));
		//DBUser newdBUser=dbUserService.getDBUserByName(request.getParameter("name"));
		System.out.println(dBUser.getName());
		System.out.println(dbuser.getPassword());
		String HashPass = BCrypt.hashpw(dbuser.getPassword(), BCrypt.gensalt(10));
			
		System.out.println(dBUser.getEmail());
		request.login(dBUser.getName(), HashPass);
		
		 return "Login Success";
	}
	
}




