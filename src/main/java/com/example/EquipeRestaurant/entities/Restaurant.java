package com.example.EquipeRestaurant.entities;

import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "restaurants")
@Data
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom")
	private String nom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "heure_ouverture")
	private LocalTime heureOuverture;
	@Column(name = "heure_fermeture")
	private LocalTime heureFermeture;
	@Column(name = "image_restaurant_url")
	private String imageRestaurantUrl;

	@OneToOne(mappedBy = "restaurant")
	@JsonIgnore
	private Carte carte;

}
