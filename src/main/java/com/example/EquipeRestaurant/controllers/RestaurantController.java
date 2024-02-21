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

import com.example.EquipeRestaurant.entities.Restaurant;
import com.example.EquipeRestaurant.services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
@Autowired private RestaurantService restbll;
	
	@GetMapping
	public ResponseEntity<Iterable<Restaurant>> findAll() {
		return new ResponseEntity<>(restbll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Restaurant> find(@PathVariable("id") int id) {
		return new ResponseEntity<>(restbll.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Restaurant p) {
		restbll.save(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Restaurant p) {
		p.setId(id);
		restbll.save(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		restbll.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
