package com.example.EquipeRestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EquipeRestaurant.entities.Employe;
import com.example.EquipeRestaurant.services.EmployeService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private EmployeService service;

	/*
	 * Endpoint utilisé pour authentifier un utilisateur au moment du login.
	 * Renvoie une erreur 401 "Unauthorized" si le couple identifiant / mdp est faux
	 * Renvoie un user avec son token si la connexion réussit
	 */
	@PostMapping
	public ResponseEntity<Employe> get(@RequestParam String email, @RequestParam String password) {
		Employe employe = service.getByLoginAndPassword(email, password);
		if ( employe == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>(employe, HttpStatus.OK);
		}
	} 
}
