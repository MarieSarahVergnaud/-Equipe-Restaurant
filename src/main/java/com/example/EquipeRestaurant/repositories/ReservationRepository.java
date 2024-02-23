package com.example.EquipeRestaurant.repositories;

import com.example.EquipeRestaurant.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {

    List<Reservation> findByRestaurantIdAndEtat(int restaurantId, String etat);
}
