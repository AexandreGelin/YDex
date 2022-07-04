package com.j2ee.sorties.controllers;

import com.j2ee.sorties.entities.Pokemon;
import com.j2ee.sorties.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @RequestMapping(method = RequestMethod.PUT)
    public Pokemon createOrUpdate(@RequestBody @Valid Pokemon pokemon) {
        return pokemonService.createOrUpdate(pokemon);
    }

    @RequestMapping(path = "/{pokename}", method = RequestMethod.GET)
    public Pokemon get(@PathVariable(name = "pokename") String pokename) {
        return pokemonService.getUserById(pokename);
    }

    @Operation(summary = "Récupération de tous les pokemons")
    @RequestMapping(path = "/_all", method = RequestMethod.GET)
    public List<Pokemon> getAllUsers() {
        return pokemonService.getAllPokemons();
    }

    @RequestMapping(path = "/{pokename}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(name = "pokename") String pokename) {
        pokemonService.deletePokemon(pokename);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Pokemon> getUsers(Pageable pageable) {
        return pokemonService.getPokemonsWithPaging(pageable);
    }
}
