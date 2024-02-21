package com.example.EquipeRestaurant.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cartes")
@Data
public class Carte {

	private int id;

	@Column(name = "nom")
	private String nom;

	@OneToMany
	@JoinColumn(name = "id_carte")
	private List<Plat> plats;

	private Restaurant restaurant;
}
