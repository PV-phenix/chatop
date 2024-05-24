package com.openclassrooms.chatop.repository;

import com.openclassrooms.chatop.model.Rental;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RentalRepository extends JpaRepository<Rental, Integer> {

	public List<Rental> findAll();

	public Rental findById(long id);

	public Rental save(Rental rental);
	
}
