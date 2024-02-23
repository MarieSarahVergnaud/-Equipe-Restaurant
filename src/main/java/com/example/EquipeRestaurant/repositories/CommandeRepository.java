package com.example.EquipeRestaurant.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Commande;

public interface CommandeRepository extends CrudRepository<Commande, Integer> {
	
	List<Commande> findByEtatContainingAndTableRestaurantIdEquals(String etat, int id_restaurant);

}
