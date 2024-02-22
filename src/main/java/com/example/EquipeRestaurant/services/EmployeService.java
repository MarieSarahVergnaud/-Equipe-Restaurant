package com.example.EquipeRestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Employe;
import com.example.EquipeRestaurant.repositories.EmployeRepository;

@Service
public class EmployeService {
@Autowired private EmployeRepository dao;
	
	public Iterable<Employe> findAll() {
		return dao.findAll();
	}
	
	public Employe findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(Employe p) {
		dao.save(p);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
}
