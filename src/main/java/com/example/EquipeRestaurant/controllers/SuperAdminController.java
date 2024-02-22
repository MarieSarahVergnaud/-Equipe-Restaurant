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

import com.example.EquipeRestaurant.entities.SuperAdmin;
import com.example.EquipeRestaurant.services.SuperAdminService;

@RestController
@RequestMapping("/superadmins")
public class SuperAdminController {
	
@Autowired private SuperAdminService supbll;
	
	@GetMapping
	public ResponseEntity<Iterable<SuperAdmin>> findAll() {
		return new ResponseEntity<>(supbll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<SuperAdmin> find(@PathVariable("id") int id) {
		return new ResponseEntity<>(supbll.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody SuperAdmin p) {
		supbll.save(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody SuperAdmin p) {
		p.setId(id);
		supbll.save(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		supbll.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
