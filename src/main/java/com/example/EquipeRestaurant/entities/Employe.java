package com.example.EquipeRestaurant.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "employes")
@Data
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "email")
	private String email;
	// Json Ignore pour ne pas renvoyer les password
	@JsonIgnore
	@Column(name = "password")
	private String password;
	@Column(name = "token")
	private String token;
	@Column(name = "role")
	private String role;
	@Column(name = "expiration_time")
	private LocalDateTime expirationTime;

	@OneToOne
	@JoinColumn(name = "id_restaurant")
	private Restaurant restaurant;
}
