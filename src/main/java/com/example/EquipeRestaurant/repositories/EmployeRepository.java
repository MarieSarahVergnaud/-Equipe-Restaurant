package com.example.EquipeRestaurant.repositories;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Employe;

public interface EmployeRepository extends CrudRepository<Employe, Integer>{
	/*
	 * Nous permettra de retrouver un utilisateur d'après son token d'identification,
	 * à condition que le token n'ait pas expiré.
	 * Cette méthode est utilisée pour retrouver un utilisateur qui s'est déjà connecté.
	 */
	public Employe findByTokenIsAndExpirationTimeAfter(String token, LocalDateTime expirationTime );
	
	/*
	 * Nous permettra de retrouver un utilisateur d'après son identifiant / mdp
	 * Cette méthode est utilisée pour trouver un utilisateur au moment de la connexion.
	 */
	
	public Employe findByEmailIsAndPasswordIs(String email, String password );
	
}
