package com.example.EquipeRestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Tables;
import com.example.EquipeRestaurant.repositories.TableRepository;

@Service
public class TableService {
	@Autowired
	private TableRepository tableRepository;

	public Iterable<Tables> findAll() {
		return tableRepository.findAll();
	}

	public Tables findById(int id) {
		return tableRepository.findById(id).get();
	}

	public void save(Tables p) {
		tableRepository.save(p);
	}

	public void delete(int id) {
		tableRepository.deleteById(id);
	}
}
