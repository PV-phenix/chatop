package com.openclassrooms.chatop.repository;


import com.openclassrooms.chatop.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByName(String name);

	public User findByEmail(String email);
	
	public User findById(long id);
	
	public List<User> findAll();
	
	@SuppressWarnings("unchecked")
	public User save(User user);
	
}
