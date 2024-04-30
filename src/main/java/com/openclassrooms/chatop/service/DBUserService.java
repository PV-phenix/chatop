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
		
		return dbUserRepository.findUserById(id);

	}
	
	public Iterable<DBUser> getAllDBUsers() { 
		
		return dbUserRepository.findAll();

	}
	
	public DBUser getDBUserByEmail(String email) { 
		
		DBUser dbuser = dbUserRepository.findUserByEmail(email);
		
		return dbUserRepository.findUserByName(dbuser.getName());

	}
	
	public DBUser save(DBUser dbUser) { 
		
		final DBUser dBUser = new DBUser();
		dBUser.setName(dbUser.getName());
		dBUser.setPassword(dbUser.getPassword());
		dBUser.setEmail(dbUser.getEmail());
		
		return dbUserRepository.save(dbUser);

	}
}
