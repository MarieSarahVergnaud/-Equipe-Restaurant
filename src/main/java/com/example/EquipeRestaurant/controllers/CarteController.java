package com.example.EquipeRestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EquipeRestaurant.entities.Carte;
import com.example.EquipeRestaurant.services.CarteService;

@RestController
@RequestMapping("/carte")
public class CarteController {

	@Autowired
	private CarteService carteService;

	@GetMapping
	public ResponseEntity<Iterable<Carte>> findAll() {
		return new ResponseEntity<>(carteService.getAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Carte> find(@PathVariable("id") int id) {
		return new ResponseEntity<>(carteService.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Carte c) {
		carteService.save(c);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Carte c) {
		c.setId(id);
		carteService.save(c);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		carteService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
