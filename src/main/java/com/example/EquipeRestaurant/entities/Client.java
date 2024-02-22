package com.example.EquipeRestaurant.entities;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "clients")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}

