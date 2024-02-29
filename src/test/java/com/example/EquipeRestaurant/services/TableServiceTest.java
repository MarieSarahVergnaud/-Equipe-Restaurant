package com.example.EquipeRestaurant.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.EquipeRestaurant.entities.Tables;
import com.example.EquipeRestaurant.repositories.TableRepository;
@SpringBootTest
class TableServiceTest {

	@Autowired
	private TableRepository tableRepository;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Sql("classpath:table_insertion.sql")
     
	void testRestaurant3etEtatLibre_NombredeTableLibres() {
		List<Tables> result = tableRepository.findByRestaurantIdAndEtat(3, "LIBRE");
		assertEquals(4, result.size());
		assertEquals(6, result.get(0).getNombrePlace());
		assertEquals(8, result.get(1).getNombrePlace());
		assertEquals(3, result.get(2).getNombrePlace());
		
	}



}
