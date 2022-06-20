package com.j2ee.sorties.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.j2ee.sorties.entities.Sortie;
import com.j2ee.sorties.services.SortieService;

import io.swagger.v3.oas.annotations.Operation;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/sorties")
public class SortieController {

	@Autowired
	private SortieService sortieService;

	@Operation(summary = "Récupération d'une sortie à partir de son identifiant")
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Sortie getSortie(@PathVariable(value = "id") Long id) {
		return sortieService.getSortieById(id);
	}

	@Operation(summary = "Création ou mise à jour d'une sortie")
	@RequestMapping(method = RequestMethod.PUT)
	public Sortie addSortie(@RequestBody @Valid Sortie sortie) {
		return sortieService.createOrUpdate(sortie);
	}

	@Operation(summary = "Récupération de toutes les sorties")
	@RequestMapping(path = "_all", method = RequestMethod.GET)
	public List<Sortie> getSorties() {
		return sortieService.getSorties();
	}

	@Operation(summary = "Suppression d'une sortie")
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public void deleteSortie(@PathVariable(value = "id") Long id) {
		sortieService.deleteSortieById(id);
	}

	@Operation(summary = "Ajout d'un utilisateur à une sortie")
	@RequestMapping(path = "/{id}/user/{username}", method = RequestMethod.PUT)
	public void addUser(@PathVariable(value = "id") Long sortieId, @PathVariable(value = "username") String username) {
		sortieService.addUser(sortieId, username);
	}
	
	@Operation(summary = "Suppression d'un utilisateur à une sortie")
	@RequestMapping(path = "/{id}/user/{username}", method = RequestMethod.DELETE)
	public void removeUser(@PathVariable(value = "id") Long sortieId, @PathVariable(value = "username") String username) {
		sortieService.removeUser(sortieId, username);
	}
}
