package com.example.EquipeRestaurant.repositories;

import com.example.EquipeRestaurant.entities.Reservation;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation,Integer> {

    List<Reservation> findByRestaurantIdAndEtat(int restaurantId, String etat);

	List<Reservation> findByRestaurantId(int restaurantId);

    @Query("SELECT r FROM Reservation r WHERE r.restaurant.id = :restaurantId AND r.date = :currentDate")
	List<Reservation> findByRestaurantIdAndCurrentDate(int restaurantId, LocalDate currentDate);
	
    @Query("SELECT r FROM Reservation r WHERE r.restaurant.id = :restaurantId AND r.date >= :tomorrow")
    List<Reservation> findByRestaurantIdAndTomorrowOrLater(int restaurantId, LocalDate tomorrow);

}
