package com.openclassrooms.chatop.service;

import com.openclassrooms.chatop.model.User;
import com.openclassrooms.chatop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	public User getUserById(long id) { 
		
		return userRepository.findById(id);

	}
	
	public Iterable<User> getAllUsers() { 
		
		return userRepository.findAll();

	}
	
	public User getUserByEmail(String email) { 
		
			
		return userRepository.findByEmail(email);

	}	
	
	public User getUserByName(String name) { 
		
		 return userRepository.findByName(name);

	}
	
	
	
	public User save(User user) { 
		
		//final User user = new User();
//		user.setName(userPrincipal.getUsername());
//		user.setPassword(userPrincipal.getPassword());
		//user.setEmail((userPrincipal.getEmail());
		
		return userRepository.save(user);

	}
}
