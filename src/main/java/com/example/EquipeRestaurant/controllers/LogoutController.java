package com.example.EquipeRestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EquipeRestaurant.services.EmployeService;

@RestController
@CrossOrigin
@RequestMapping("/logout")
public class LogoutController {
	@Autowired
	private EmployeService service;

	/*
	 * Endpoint utilisé pour deconnecter un utilisateur grace à son token
	 */
	@GetMapping
	public void logout(@RequestHeader("token") String token) {
		service.logout(token);
	}

}
