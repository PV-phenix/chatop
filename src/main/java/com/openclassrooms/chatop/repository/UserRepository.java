package com.openclassrooms.chatop.repository;

import com.openclassrooms.chatop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findById(long id);

	List<User> findAll();

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
