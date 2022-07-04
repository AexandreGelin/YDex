package com.j2ee.sorties.services;
import java.util.List;
import java.util.Optional;

import com.j2ee.sorties.dto.exceptions.ResourceNotFoundException;
import com.j2ee.sorties.entities.Pokemon;
import com.j2ee.sorties.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PokemonService  {
    @Autowired
    private PokemonRepository pokemonRepository;

    public Pokemon createOrUpdate(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public Pokemon getUserById(String id_poke) {
        return pokemonRepository.findById(id_poke).orElse(null);
    }


    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Page<Pokemon> getPokemonsWithPaging(Pageable pageable) {
        return pokemonRepository.findAll(pageable);
    }

    public void deletePokemon(String username) {
        pokemonRepository.deleteById(username);
    }


}
