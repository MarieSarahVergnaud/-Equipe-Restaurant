package com.example.EquipeRestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Plat;
import com.example.EquipeRestaurant.repositories.PlatRepository;

import java.util.List;

@Service
public class PlatService {
	@Autowired
	private PlatRepository platRepository;

	public Iterable<Plat> findAll() {
		return platRepository.findAll();
	}

	public Plat findById(int id) {
		return platRepository.findById(id).get();
	}

	public void save(Plat p) {
		platRepository.save(p);
	}

	public void delete(int id) {
		platRepository.deleteById(id);
	}


	public List<Plat> getPlatsByRestaurantId(Integer restaurantId) {
		return platRepository.getPlatsByRestaurantId(restaurantId);
	}

}
