package com.example.EquipeRestaurant.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Reservation;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {

    List<Reservation> findByRestaurantIdAndEtat(int restaurantId, String etat);

	List<Reservation> findByRestaurantIdAndDate(int restaurantId, LocalDate date);
}
