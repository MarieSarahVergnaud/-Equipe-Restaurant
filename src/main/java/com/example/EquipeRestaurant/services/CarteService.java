package com.example.EquipeRestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Carte;
import com.example.EquipeRestaurant.repositories.CarteRepository;

@Service
public class CarteService {
	@Autowired
	private CarteRepository carteRepository;

	public Iterable<Carte> getAll() {
		return carteRepository.findAll();
	}

	public Carte getById(int id) {
		return carteRepository.findById(id).get();
	}

	public void save(Carte Carte) {
		carteRepository.save(Carte);
	}

	public void delete(int id) {
		carteRepository.deleteById(id);
	}
}
