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

import com.example.EquipeRestaurant.entities.Message;
import com.example.EquipeRestaurant.services.MessageService;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
@Autowired private MessageService mesbll;
	
	@GetMapping
	public ResponseEntity<Iterable<Message>> findAll() {
		return new ResponseEntity<>(mesbll.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Message> find(@PathVariable("id") int id) {
		return new ResponseEntity<>(mesbll.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Message p) {
		mesbll.save(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Message p) {
		p.setId(id);
		mesbll.save(p);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		mesbll.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
