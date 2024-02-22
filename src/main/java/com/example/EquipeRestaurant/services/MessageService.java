package com.example.EquipeRestaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Message;
import com.example.EquipeRestaurant.repositories.MessageRepository;

@Service
public class MessageService {
	@Autowired private MessageRepository dao;
	
	public Iterable<Message> findAll() {
		return dao.findAll();
	}
	
	public Message findById(int id) {
		return dao.findById(id).get();
	}
	
	public void save(Message p) {
		dao.save(p);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
}
