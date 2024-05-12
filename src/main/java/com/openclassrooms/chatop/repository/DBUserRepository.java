package com.openclassrooms.chatop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.chatop.model.DBUser;


public interface DBUserRepository extends JpaRepository<DBUser, Long> {
	
	public DBUser findByName(String name);

	public DBUser findByEmail(String email);
	
	public DBUser findById(long id);
	
	public List<DBUser> findAll();
	
	@SuppressWarnings("unchecked")
	public DBUser save(DBUser dbUser);
	
}
