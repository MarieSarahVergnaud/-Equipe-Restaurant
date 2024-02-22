package com.example.EquipeRestaurant.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "etat")
    private String etat;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "heure")
    private LocalTime heure;
    @Column(name = "nombre_place")
    private int nbrPlace;

    @ManyToOne
    @JoinColumn(name = "id_restaurant")
    private Restaurant restaurant;
    @JoinColumn(name = "id_client")
    @ManyToOne
    private Client client;
    @JoinColumn(name = "id_table")
    @ManyToOne
    private Tables tables;
//correction


}
