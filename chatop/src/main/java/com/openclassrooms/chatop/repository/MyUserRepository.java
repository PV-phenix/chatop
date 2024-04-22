package com.openclassrooms.chatop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.chatop.model.DBUser;


public interface MyUserRepository extends JpaRepository<DBUser, Long> {
	
//	@Query("select u from User u where u.login = :login")
//	User findByLogin(@Param("login") String login);
	
//	@Query("SELECT u FROM User u WHERE u.name = :name")
//	User getUserByUsername(@Param("name") String name);
//
//	@Query("select u from User u where u.email = :email")
//	User getUserByEmail(@Param("email") String email);
	public DBUser findByName(String name);

	public DBUser findUserByEmail(String email);
}
