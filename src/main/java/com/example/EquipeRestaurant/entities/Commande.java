package com.example.EquipeRestaurant.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity @Table(name="commandes")
@Data
public class Commande {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name="numero")
    private int numero;

	@OneToOne @JoinColumn(name="id_table")
    private Tables table;
	@Column(name="etat")
	private String etat;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "assocommandesplats",
			joinColumns = {@JoinColumn(name = "id_commande")},
			
			inverseJoinColumns = {@JoinColumn(name = "id_plat")}
	)
	private List<Plat> plats;
}