package com.example.EquipeRestaurant.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@jakarta.persistence.Table(name = "reservations")
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @ManyToOne
    private Restaurant restaurant;
    @ManyToOne
    private Client client;
    @ManyToOne
    private  Table table;

}
