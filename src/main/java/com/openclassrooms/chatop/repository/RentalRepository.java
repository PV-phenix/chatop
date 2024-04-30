package com.openclassrooms.chatop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openclassrooms.chatop.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

	public List<Rental> findAll();
	public Rental findById(long id);
	@SuppressWarnings("unchecked")
	public Rental save(Rental rental);
	
}
