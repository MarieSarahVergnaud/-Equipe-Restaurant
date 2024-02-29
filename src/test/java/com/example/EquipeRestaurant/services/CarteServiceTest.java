package com.example.EquipeRestaurant.services;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import com.example.EquipeRestaurant.repositories.CarteRepository;
@SpringBootTest
class CarteServiceTest {

	@Autowired
	private CarteRepository carteRepository;
	
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
	void getById1ReturnCarte1() {
		String result = carteRepository.findById(1).get().getNom();
		
		assertEquals("Carte1", result);
	}


}
