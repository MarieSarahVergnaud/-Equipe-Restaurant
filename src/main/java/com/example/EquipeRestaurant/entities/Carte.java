package com.example.EquipeRestaurant.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cartes")
@Data
public class Carte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom")
	private String nom;

	@OneToMany
	@JoinColumn(name = "id_carte")
	private List<Plat> plats;

	@OneToOne
	@JoinColumn( name= "id_restaurant")
	private Restaurant restaurant;
	


}
