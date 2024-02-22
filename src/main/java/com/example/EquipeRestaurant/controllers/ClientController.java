package com.example.EquipeRestaurant.controllers;

import com.example.EquipeRestaurant.entities.Client;
import com.example.EquipeRestaurant.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>>findAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> find(@PathVariable("id") int id) {
        return new ResponseEntity<>(clientService.getById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Client c) {
        clientService.save(c);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
