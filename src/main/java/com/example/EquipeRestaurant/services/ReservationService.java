package com.example.EquipeRestaurant.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Reservation;
import com.example.EquipeRestaurant.repositories.ReservationRepository;

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

	public List<Reservation> getReservationsByRestaurantIdAndEtat(int restaurantId, String etat) {
		return reservationRepository.findByRestaurantIdAndEtat(restaurantId, etat);
	}

	public List<Reservation> getReservationsByRestaurantIdAndDate(int restaurantId, LocalDate date) {
		return reservationRepository.findByRestaurantIdAndDate(restaurantId, date);
	}

	public List<Reservation> getReservationsByRestaurantIdAndDateAndEtat(int restaurantId, LocalDate date,
			String etat) {
		return reservationRepository.findByRestaurantIdAndDateAndEtat(restaurantId, date, etat);
	}

}
