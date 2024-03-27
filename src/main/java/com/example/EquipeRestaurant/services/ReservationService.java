package com.example.EquipeRestaurant.services;

import com.example.EquipeRestaurant.entities.Reservation;
import com.example.EquipeRestaurant.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public List<Reservation> getReservationsByRestaurantIdAndCurrentDate(int restaurantId) {
        LocalDate currentDate = LocalDate.now();
        return reservationRepository.findByRestaurantIdAndCurrentDate(restaurantId, currentDate);
    }
    
    public List<Reservation> getReservationsByRestaurantIdFromTomorrow(int restaurantId) {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return reservationRepository.findByRestaurantIdAndTomorrowOrLater(restaurantId, tomorrow);
    }

}
