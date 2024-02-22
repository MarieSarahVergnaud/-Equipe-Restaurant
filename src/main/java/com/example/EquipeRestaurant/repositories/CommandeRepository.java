package com.example.EquipeRestaurant.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Commande;

public interface CommandeRepository extends CrudRepository<Commande, Integer> {

}
