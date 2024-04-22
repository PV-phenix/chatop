package com.openclassrooms.chatop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openclassrooms.chatop.model.Rental;
import com.openclassrooms.chatop.repository.RentalRepository;

@Service
public class RentalService {
	
	
	@Autowired
	private RentalRepository rentalRepository;
	
	public Iterable<Rental> getRentals()
	{
		return rentalRepository.findAll();
	}

}
