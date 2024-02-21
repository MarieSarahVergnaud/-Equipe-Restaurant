package com.example.EquipeRestaurant.services;

import com.example.EquipeRestaurant.entities.Client;
import com.example.EquipeRestaurant.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
   @Autowired
   private ClientRepository clientRepository;


   public Iterable<Client> getAll() {
      return clientRepository.findAll();
   }

   public Client getById(int id) {
      return clientRepository.findById(id).get();
   }

   public void save(Client client) {
      clientRepository.save(client);
   }

   public void delete(int id) {
      clientRepository.deleteById(id);
   }




}
