package com.example.EquipeRestaurant.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Table(name="messages")
@Data
public class Message {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="titre")
	private String titre;
	@Column(name="contenu")
	private String contenu;
	
	@OneToOne @JoinColumn(name="id_client")
	private Client client;
	
	@OneToOne @JoinColumn(name="id_employe")
	private Employe employe;
	
}
