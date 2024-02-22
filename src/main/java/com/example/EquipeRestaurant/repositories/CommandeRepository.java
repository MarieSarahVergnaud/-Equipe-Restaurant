package com.example.EquipeRestaurant.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Commande;
import com.example.EquipeRestaurant.entities.Restaurant;

public interface CommandeRepository extends CrudRepository<Commande, Integer> {
	
	List<Commande> findByTableEtatContainingAndTableRestaurantIdEquals(String etat, int id_restaurant);

}
