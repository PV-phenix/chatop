package com.openclassrooms.chatop.controller;

import com.openclassrooms.chatop.model.Rental;
import com.openclassrooms.chatop.service.RentalService;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    @Autowired
    private RentalService rentalService;
	
	@GetMapping("/api/rentals")
	public Iterable<Rental> getRentals() {
	return rentalService.getRentals();
	}
	
	@GetMapping("/api/rentals/{id}")
	public Rental getRental(@PathVariable long id) {
		return rentalService.getRental(id);
	}
	
	@GetMapping("/api/rentals/update/{id}")
	public Rental upDateRental(@PathVariable long id) {
		return rentalService.updateRental(id);
	}

	@GetMapping("/api/rentals/create")
	public Rental createRental() {
		Rental newRental = new Rental();
		newRental.setName("Studio");
		newRental.setSurface(70);
		newRental.setPrice(375000);
		newRental.setUpdated_at(LocalDateTime.now());
		newRental.setCreated_at(LocalDateTime.now());
		return rentalService.createRental(newRental);
	}

}

