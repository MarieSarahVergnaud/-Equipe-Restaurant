package com.example.EquipeRestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EquipeRestaurant.entities.Plat;
import com.example.EquipeRestaurant.services.PlatService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/plat")
public class PlatController {
	@Autowired
	private PlatService ps;

	
	@GetMapping
	public ResponseEntity<Iterable<Plat>> findAll() {
		return new ResponseEntity<>(ps.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Plat> find(@PathVariable("id") int id) {
		return new ResponseEntity<>(ps.findById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Plat p) {
		ps.save(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Plat p) {
		p.setId(id);
		ps.save(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		ps.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("restaurant/{restaurantId}")
	public ResponseEntity<List<Plat>> getPlatsByRestaurant(@PathVariable("restaurantId") int restaurantId) {
		List<Plat> plats = ps.getPlatsByRestaurantId(restaurantId);
		 return new ResponseEntity<>(plats,HttpStatus.OK);
	}

}
