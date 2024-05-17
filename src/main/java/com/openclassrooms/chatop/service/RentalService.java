package com.openclassrooms.chatop.service;

import com.openclassrooms.chatop.model.Rental;
import com.openclassrooms.chatop.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
	
	
	@Autowired
	private RentalRepository rentalRepository;
	
	public Rental getRental(long id)
	{
		return rentalRepository.findById(id);
	}
	
	public Iterable<Rental> getRentals()
	{
		return rentalRepository.findAll();
	}
	
	public Rental createRental(Rental rental) { 
		
		final Rental newRental = new Rental();
		newRental.setName(rental.getName());
		newRental.setSurface(rental.getSurface());
		newRental.setPrice(rental.getPrice());
		newRental.setPicture(rental.getPicture());
		newRental.setDescription(rental.getDescription());
		newRental.setOwner_id(rental.getOwner_id());
		newRental.setCreated_at(rental.getCreated_at());
		newRental.setUpdated_at(rental.getUpdated_at());
		
		return rentalRepository.save(newRental);
	}

	public Rental updateRental(long id) {
	    Rental upRental = rentalRepository.findById(id);
		upRental.setName ("Loft");
		upRental.setSurface(32);
		upRental.setPrice(450000);
		return rentalRepository.save(upRental);
	}

}
