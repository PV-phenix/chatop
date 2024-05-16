package com.openclassrooms.chatop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.chatop.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByName(String name);

	public User findByEmail(String email);
	
	public User findById(long id);
	
	public List<User> findAll();
	
	@SuppressWarnings("unchecked")
	public User save(User user);
	
}
