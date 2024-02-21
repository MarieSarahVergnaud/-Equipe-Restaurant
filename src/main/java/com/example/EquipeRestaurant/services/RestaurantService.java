package com.example.EquipeRestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Restaurant;
import com.example.EquipeRestaurant.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired private RestaurantRepository dao;
	
	public Iterable<Restaurant> findAll() {
		return dao.findAll();
	}
	
	public Restaurant findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(Restaurant p) {
		dao.save(p);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
}