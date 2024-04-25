package com.openclassrooms.chatop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.chatop.model.DBUser;


public interface DBUserRepository extends JpaRepository<DBUser, Long> {
	
	public DBUser findUserByName(String name);

	public DBUser findUserByEmail(String email);
}
