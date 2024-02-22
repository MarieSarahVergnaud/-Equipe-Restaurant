package com.example.EquipeRestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Commande;
import com.example.EquipeRestaurant.entities.Restaurant;
import com.example.EquipeRestaurant.repositories.CommandeRepository;

@Service
public class CommandeService {
	@Autowired private CommandeRepository dao;
	
	public Iterable<Commande> findAll() {
		return dao.findAll();
	}
	
	public Commande findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(Commande p) {
		dao.save(p);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public List<Commande> findByEtatEnPrepa(int id_restaurant){
		return dao.findByTableEtatContainingAndTableRestaurantIdEquals("EN PREPA", id_restaurant);
	}
	
}
