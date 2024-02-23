package com.example.EquipeRestaurant.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Plat;

public interface PlatRepository extends CrudRepository<Plat, Integer> {
	
	@Query(value = "SELECT plats.*\r\n"
			+ "	FROM plats\r\n"
			+ "	JOIN assocommandesplats ON plats.id = assocommandesplats.id_plat\r\n"
			+ "	JOIN commandes ON assocommandesplats.id_commande = commandes.id\r\n"
			+ "	WHERE commandes.id = :id_commande", nativeQuery = true)
	List<Plat> recapCommande(int id_commande);
}
