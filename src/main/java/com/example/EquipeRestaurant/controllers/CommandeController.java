package com.example.EquipeRestaurant.controllers;

import java.util.List;

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

import com.example.EquipeRestaurant.entities.Commande;
import com.example.EquipeRestaurant.services.CommandeService;

@RestController
@RequestMapping("/commandes")
public class CommandeController {
	
	@Autowired private CommandeService combll;
	
	@GetMapping
	public ResponseEntity<Iterable<Commande>> findAll() {
		return new ResponseEntity<>(combll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Commande> find(@PathVariable("id") int id) {
		return new ResponseEntity<>(combll.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Commande p) {
		combll.save(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Commande p) {
		p.setId(id);
		combll.save(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		combll.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("commandesenprepa/{id}")
	public ResponseEntity<List<Commande>>findByEtatEnPrepa(@PathVariable int id){
		return new ResponseEntity<>(combll.findByEtatEnPrepa(id), HttpStatus.OK);
	}
	
	@GetMapping("commandesprete/{id}")
	public ResponseEntity<List<Commande>>findByEtatPrete(@PathVariable int id){
		return new ResponseEntity<>(combll.findByEtatPrete(id), HttpStatus.OK);
	}
	
	@GetMapping("commandesservie/{id}")
	public ResponseEntity<List<Commande>>findByEtatServie(@PathVariable int id){
		return new ResponseEntity<>(combll.findByEtatServie(id), HttpStatus.OK);
	}
	
	@GetMapping("commandesreglee/{id}")
	public ResponseEntity<List<Commande>>findByEtatReglee(@PathVariable int id){
		return new ResponseEntity<>(combll.findByEtatReglee(id), HttpStatus.OK);
	}
}
