package com.openclassrooms.chatop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.openclassrooms.chatop.model.Rental;
import com.openclassrooms.chatop.service.RentalService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class ChatopApplication implements CommandLineRunner{

	@Autowired
	private RentalService rentalService;
	
	public static void main(String[] args) {
		SpringApplication.run(ChatopApplication.class, args);
	}
	
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
	Iterable<Rental> rentals = rentalService.getRentals();
	rentals.forEach(rental -> System.out.println(rental.getName()));
	
	}
}
