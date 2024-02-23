package com.example.EquipeRestaurant.services;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EquipeRestaurant.entities.Employe;
import com.example.EquipeRestaurant.repositories.EmployeRepository;

@Service
public class EmployeService {
	@Autowired
	private EmployeRepository dao;

	public Iterable<Employe> findAll() {
		return dao.findAll();
	}

	public Employe findById(int id) {
		return dao.findById(id).get();
	}

	public void save(Employe p) {
		dao.save(p);
	}

	public void delete(int id) {
		dao.deleteById(id);
	}

	/*
	 * Quand on se connecte avec login et mdp, on crée un token aléatoire qu'on
	 * renverra à l'utilisateur pour ses accès futurs. Ici, le token est configuré
	 * pour expirer après 30 minutes d'inactivité
	 */
	public Employe getByLoginAndPassword(String email, String password) {
		Employe employe = dao.findByEmailIsAndPasswordIs(email, password);
		if (employe != null) {
			employe.setToken(generateToken());
			employe.setExpirationTime(LocalDateTime.now().plusMinutes(30));
			dao.save(employe);
		}
		return employe;
	}

	/*
	 * Quand on s'identifie avec le token, on en profite pour mettre à jour la date
	 * d'expiration du token. Ainsi, tant que l'utilisateur est actif sur
	 * l'application, le token n'expire pas.
	 */

	public Employe getByToken(String token) {
		Employe employe = dao.findByTokenIsAndExpirationTimeAfter(token, LocalDateTime.now());
		if (employe != null) {
			employe.setExpirationTime(LocalDateTime.now().plusMinutes(30));
			dao.save(employe);
		}
		return employe;
	}

	/*
	 * Les attributs static suivants et la méthode generateToken sont des outils
	 * nous permettant de générer un token aléatoire de 64 caractères de long.
	 */

	private static final SecureRandom secureRandom = new SecureRandom();
	private static final Encoder base64encoder = Base64.getUrlEncoder();

	private String generateToken() {
		byte[] randomBytes = new byte[48];
		secureRandom.nextBytes(randomBytes);
		return base64encoder.encodeToString(randomBytes);
	}

}
