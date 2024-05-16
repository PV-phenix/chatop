package com.openclassrooms.chatop.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.chatop.model.User;
import com.openclassrooms.chatop.model.UserPrincipal;
import com.openclassrooms.chatop.service.MyUserDetailsService;
import com.openclassrooms.chatop.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
    @Autowired
    private UserService userService;
    
   
    @Autowired
    private static final Logger myLogger = LoggerFactory.getLogger(MyUserDetailsService.class);
    

	
	
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
	
//	@GetMapping("/api/auth/logout")
//	public String logout(@Validated UserPrincipal userPrincipal,  HttpServletRequest request,Authentication authentication) throws ServletException
//	{
//        String userName = userPrincipal.getUsername();
//        if (request.) {
//		    HttpSession session = request.getSession(false);
//		    userPrincipal.setUser().
//		    if (session != null) {
//		    	
//		        session.invalidate();
//		    }
//		}
//		request.logout();
//		return "Deconnecté(e)";
//	}
	


	@GetMapping("/api/auth/me")
	public String getAuthMe(@Validated UserPrincipal userPrincipal,  HttpServletRequest request) {
		
		return "<h3 th:inline=\"text\">Welcome</h3>";
	}

	
    @PostMapping("/api/auth/register")
    //@ResponseBody
    public String UserCreation(@RequestBody UserPrincipal userPrincipal, HttpServletRequest request) 
    {
    	myLogger.debug("Registering user account with information: {}", userPrincipal);
    	User user = userPrincipal.getUser();
        System.out.println("start register method");
        user.setName(userPrincipal.getUsername());
        user.setPassword(userPrincipal.getPassword());
        user.setRole("USER");
        user.setCreated_at(LocalDateTime.now());
        user.setPassword(BCrypt.hashpw(userPrincipal.getPassword(), BCrypt.gensalt(10) ));
        //String Password = request.getParameter("password");
        //String ConfirmedPassword = request.getParameter("confirm_password");
        System.out.println("user: "+user.getName() + " email: "+user.getEmail()+" pass: "+user.getPassword());
       
        userService.save(user);
        return "register";
    }

	
	@GetMapping("/api/user/{id}")
	public User getUserById(@PathVariable long id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/api/users")
	public Iterable<User> getUsers( ) {
		return userService.getAllUsers();
	}
	
	@PostMapping("/api/auth/login")
	public String UserLogin(@RequestBody UserPrincipal userPrincipal, HttpServletRequest request) throws ServletException  
	{
		System.out.println("start login method");
		System.out.println(userPrincipal.getUsername());
		
		User user=userService.getUserByName(userPrincipal.getUsername());
		
		//dBUser.setRole("USER");
		//DBUser dBUser=dbUserService.getDBUserByEmail(request.getParameter("email"));
		//DBUser newdBUser=dbUserService.getDBUserByName(request.getParameter("name"));
		System.out.println(userPrincipal.getUsername());
		System.out.println(userPrincipal.getPassword());
		//String HashPass = BCrypt.hashpw(dbuser.getPassword(), BCrypt.gensalt(10));
			
//		System.out.println(userPrincipal.getEmail());
		//request.login(dBUser.getName(), dBUser.getPassword());//HashPass
		
		 return "Login Success";
	}
	
}




