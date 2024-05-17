package com.openclassrooms.chatop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
public class Rental {
	
    public Rental() {
  	  
    }
 
    public Rental(String name, int surface, int price) {
        this.name = name;
        this.surface = surface;
        this.price= price;
        
        
    }
	
	   @Id
	    @Column(name = "id")
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	    @Column(name = "name")
		private String name;
	    
	    @Column(name = "surface")	    
	    private int surface;
    
	    @Column(name = "price")	    
	    private int price;
	    
	    @Column(name = "picture")	    
	    private String picture;
	    
	    @Column(name = "description")	    
	    private String description;
	    
	    @Column(name = "owner_id")	    
	    private int owner_id;
	    
	    @Column(name = "created_at")	 	    
		private LocalDateTime created_at;
	    
	    @Column(name = "updated_at")	    
		private LocalDateTime updated_at;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getSurface() {
			return surface;
		}
		public void setSurface(int surface) {
			this.surface = surface;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getOwner_id() {
			return owner_id;
		}
		public void setOwner_id(int owner_id) {
			this.owner_id = owner_id;
		}
		public LocalDateTime getCreated_at() {
			return created_at;
		}
		public void setCreated_at(LocalDateTime created_at) {
			this.created_at = created_at;
		}
		public LocalDateTime getUpdated_at() {
			return updated_at;
		}
		public void setUpdated_at(LocalDateTime updated_at) {
			this.updated_at = updated_at;
		}
		

	
}
