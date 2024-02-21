package com.example.EquipeRestaurant.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "plats")
@Data

public class Plat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prix")
	private String prix;

	@Column(name = "description")
	private String description;

	@Column(name = "categorie")
	private String categorie;

	@Column(name = "image_plat_url")
	private String image_plat_url;

	

}
