package com.example.EquipeRestaurant.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Tables;

public interface TableRepository extends CrudRepository<Tables, Integer> {
	
//	List<Tables> findByRestaurantIdAndEtat( int id, String etat);

	List<Tables> findByRestaurantId(int id);
	
	
	
	
}
