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

import com.example.EquipeRestaurant.entities.Employe;
import com.example.EquipeRestaurant.services.EmployeService;

@RestController
@RequestMapping("/employes")
public class EmployeController {
	
@Autowired private EmployeService empbll;
	
	@GetMapping
	public ResponseEntity<Iterable<Employe>> findAll() {
		return new ResponseEntity<>(empbll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Employe> find(@PathVariable("id") int id) {
		return new ResponseEntity<>(empbll.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Employe p) {
		empbll.save(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Employe p) {
		p.setId(id);
		empbll.save(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		empbll.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
