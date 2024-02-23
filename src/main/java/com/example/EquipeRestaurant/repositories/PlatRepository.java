package com.example.EquipeRestaurant.repositories;


import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Plat;
import org.springframework.data.repository.query.Param;


public interface PlatRepository extends CrudRepository<Plat, Integer> {
	
	@Query(value = "SELECT plats.*\r\n"
			+ "	FROM plats\r\n"
			+ "	JOIN assocommandesplats ON plats.id = assocommandesplats.id_plat\r\n"
			+ "	JOIN commandes ON assocommandesplats.id_commande = commandes.id\r\n"
			+ "	WHERE commandes.id = :id_commande", nativeQuery = true)
	List<Plat> recapCommande(int id_commande);


public interface PlatRepository extends CrudRepository<Plat, Integer> {
    @Query(value = "SELECT plats.* FROM plats " +
            "INNER JOIN cartes ON plats.id_carte = cartes.id " +
            "INNER JOIN restaurants ON cartes.id_restaurant = restaurants.id " +
            "WHERE restaurants.id = :idRestaurant", nativeQuery = true)
    List<Plat> getPlatsByRestaurantId(@Param("idRestaurant") int idRestaurant);

}
