package com.example.EquipeRestaurant.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "reservations")
@Data
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Restaurant restaurant;
	@ManyToOne
	private Client client;

	// A CHANGER
	@ManyToOne
	private Tables table;

}
