package com.example.EquipeRestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.SuperAdmin;
import com.example.EquipeRestaurant.repositories.SuperAdminRepository;

@Service
public class SuperAdminService {
	@Autowired private SuperAdminRepository dao;
	
	public Iterable<SuperAdmin> findAll() {
		return dao.findAll();
	}
	
	public SuperAdmin findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(SuperAdmin p) {
		dao.save(p);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
}
