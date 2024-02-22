package com.example.EquipeRestaurant.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tables")
@Data

public class Tables {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@Column(name = "numero")
	private int numero;

	@Column(name = "nombre_place")
	private int nombrePlace;

	@Column(name = "etat")
	private String etat;

	@OneToOne
	@JoinColumn( name= "id_restaurant")
	private Restaurant restaurant;
}
