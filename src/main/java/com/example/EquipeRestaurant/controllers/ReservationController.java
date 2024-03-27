package com.example.EquipeRestaurant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EquipeRestaurant.entities.Reservation;
import com.example.EquipeRestaurant.services.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Reservation>> findAll() {
        return new ResponseEntity<>(reservationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") int id) {
        Reservation reservation = reservationService.getById(id);
        if (reservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable("id") int id, @RequestBody Reservation reservation) {
        Reservation existingReservation = reservationService.getById(id);
        if (existingReservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        reservation.setId(id);
        reservationService.save(reservation);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") int id) {
        Reservation existingReservation = reservationService.getById(id);
        if (existingReservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        reservationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/today/restaurant/{id}")
    public ResponseEntity<List<Reservation>> getReservationsByRestaurantIdAndCurrentDate(@PathVariable("id") int id) {
        List<Reservation> reservations = reservationService.getReservationsByRestaurantIdAndCurrentDate(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
       
    }
    
    @GetMapping("/tomorrow/restaurant/{id}")
    public ResponseEntity<List<Reservation>> getReservationsByRestaurantIdFromTomorrow(@PathVariable("id") int id) {
        List<Reservation> reservations = reservationService.getReservationsByRestaurantIdFromTomorrow(id);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

}

