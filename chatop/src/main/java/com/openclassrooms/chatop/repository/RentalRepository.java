package com.openclassrooms.chatop.repository;

import org.springframework.data.repository.CrudRepository;

import com.openclassrooms.chatop.model.Rental;

public interface RentalRepository extends CrudRepository<Rental, Integer> {

	public Iterable<Rental> findAll();
	
	
}
