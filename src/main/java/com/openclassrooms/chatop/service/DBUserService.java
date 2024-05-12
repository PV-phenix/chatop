package com.openclassrooms.chatop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.chatop.model.DBUser;
import com.openclassrooms.chatop.repository.DBUserRepository;

@Service
public class DBUserService {
	
	@Autowired
	private DBUserRepository dbUserRepository;
	

	public DBUser getDBUserById(long id) { 
		
		return dbUserRepository.findById(id);

	}
	
	public Iterable<DBUser> getAllDBUsers() { 
		
		return dbUserRepository.findAll();

	}
	
	public DBUser getDBUserByEmail(String email) { 
		
			
		return dbUserRepository.findByEmail(email);

	}	
	
	public DBUser getDBUserByName(String name) { 
		
		 return dbUserRepository.findByName(name);

	}
	
	
	
	public DBUser save(DBUser dbUser) { 
		
		final DBUser dBUser = new DBUser();
		dBUser.setName(dbUser.getName());
		dBUser.setPassword(dbUser.getPassword());
		dBUser.setEmail(dbUser.getEmail());
		
		return dbUserRepository.save(dbUser);

	}
}
