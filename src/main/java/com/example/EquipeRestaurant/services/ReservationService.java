package com.example.EquipeRestaurant.services;

import com.example.EquipeRestaurant.entities.Client;
import com.example.EquipeRestaurant.entities.Reservation;
import com.example.EquipeRestaurant.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;


    public Iterable<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Reservation getById(int id) {
        return reservationRepository.findById(id).get();
    }

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void delete(int id) {
        reservationRepository.deleteById(id);
    }
}
