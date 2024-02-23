package com.example.EquipeRestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.dto.Addition;
import com.example.EquipeRestaurant.entities.Plat;
import com.example.EquipeRestaurant.repositories.PlatRepository;

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

	public Addition recapCommande(int id_commande) {
		Addition addition = new Addition();
		List<Plat> plats = platRepository.recapCommande(id_commande);
		
		int totalAddition = 0;
        for (Plat plat : plats) {
            totalAddition += plat.getPrix();
        }
        
        addition.setPlats(plats);
        addition.setTotalAddition(totalAddition);
        
		return addition;
	}
	
	
}
