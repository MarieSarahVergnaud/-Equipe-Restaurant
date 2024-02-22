package com.example.EquipeRestaurant.repositories;

import com.example.EquipeRestaurant.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
}
