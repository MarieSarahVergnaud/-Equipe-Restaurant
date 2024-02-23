package com.example.EquipeRestaurant.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.EquipeRestaurant.entities.Plat;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlatRepository extends CrudRepository<Plat, Integer> {
    @Query(value = "SELECT plats.* FROM plats " +
            "INNER JOIN cartes ON plats.id_carte = cartes.id " +
            "INNER JOIN restaurants ON cartes.id_restaurant = restaurants.id " +
            "WHERE restaurants.id = :idRestaurant", nativeQuery = true)
    List<Plat> getPlatsByRestaurantId(@Param("idRestaurant") int idRestaurant);
}
