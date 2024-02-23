package com.example.EquipeRestaurant.dto;

import java.util.List;

import com.example.EquipeRestaurant.entities.Plat;

import lombok.Data;

@Data
public class Addition {
	private List<Plat> plats;
	private int totalAddition;

}
