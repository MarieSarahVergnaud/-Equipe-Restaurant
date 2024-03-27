package com.example.EquipeRestaurant.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EquipeRestaurant.entities.Tables;
import com.example.EquipeRestaurant.services.TableService;

@RestController
@CrossOrigin
@RequestMapping("/table")
public class TableController {
	@Autowired
	private TableService ts;

	@GetMapping
	public ResponseEntity<Iterable<Tables>> findAll() {
		return new ResponseEntity<>(ts.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Tables> find(@PathVariable("id") int id) {
		return new ResponseEntity<>(ts.findById(id), HttpStatus.OK);
	}

	@GetMapping(path = "/PathRestaurant/{id}")
	public ResponseEntity<List<Tables>> findByIdRestaurant(@PathVariable("id") int id) {
		return new ResponseEntity<List<Tables>>(ts.findByRestaurantId(id), HttpStatus.OK);
	}

	@PostMapping(path = "/create")
	public ResponseEntity<Void> insert(@RequestBody Tables p) {
		ts.save(p);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Tables p) {
		// creer une nouvelle instance de Tables que vous récupérez depuis votre service
		// ("original" par exemple)
		Tables original = ts.findById(id);

		// Vérifier si l'instance originale a été trouvée
		if (original == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retourner 404 si non trouvé
		}

		// affectez à "original" les nouvelles informations que vous voulez modifier -->
		// à savoir l'état
		original.setEtat(p.getEtat());

		// p.setId(id);
		ts.save(original); // au lieu de sauver "p", vous sauvez "original" dont l'état est changé
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		ts.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
