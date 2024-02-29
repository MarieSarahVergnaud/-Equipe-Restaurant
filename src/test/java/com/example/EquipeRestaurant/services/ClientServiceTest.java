package com.example.EquipeRestaurant.services;

import com.example.EquipeRestaurant.entities.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClientServiceTest {
    @Autowired
   private ClientService clientService;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Sql("classpath:table_insertion.sql")
    void getAll_Clients_number_equal_four() {
     Iterable<Client> clients = clientService.getAll();
     assertNotNull(clients);
     int count = 0;
     for (Client client : clients) {
      count++;
     }
     assertEquals(4, count);


    }

    @Test
    void getById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}