package com.openclassrooms.chatop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.openclassrooms.chatop.model.Rental;
import com.openclassrooms.chatop.service.RentalService;

public class RentalController {

    @Autowired
    private RentalService rentalService;
	
	@GetMapping("/api/rentals")
	public Iterable<Rental> getRentals() {
		
		
		return rentalService.getRentals();
	}
}
