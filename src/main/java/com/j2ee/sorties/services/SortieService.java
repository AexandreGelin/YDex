package com.j2ee.sorties.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j2ee.sorties.entities.Sortie;
import com.j2ee.sorties.entities.User;
import com.j2ee.sorties.repositories.SortieRepository;

@Service
public class SortieService {
	@Autowired
	private SortieRepository sortieRepository;
	@Autowired
	private UserService userService;
	
	public Sortie createOrUpdate(Sortie sortie) {
		return sortieRepository.save(sortie);
	}

	public List<Sortie> getSorties() {
		return sortieRepository.findAll();
	}

	public Sortie getSortieById(Long id) {
		return sortieRepository.findById(id).orElse(null);
	}

	public void deleteSortieById(Long id) {
		sortieRepository.deleteById(id);
	}
	
	public void addUser(Long sortieId, String username) {
		Sortie sortie = getSortieById(sortieId);
		User user = userService.getUserById(username);
		if (sortie != null && user != null) {
			sortie.getUsers().add(user);
			sortieRepository.save(sortie);
		}
	}
	
	public void removeUser(Long sortieId, String username) {
		Sortie sortie = getSortieById(sortieId);
		User user = userService.getUserById(username);
		if (sortie != null && user != null) {
			sortie.getUsers().remove(user);
			sortieRepository.save(sortie);
		}
	}

}
