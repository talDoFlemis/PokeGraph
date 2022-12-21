package com.flemis.PokeGraph.Life;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flemis.PokeGraph.DTO.Pokemon;
import com.flemis.PokeGraph.Repositories.PokemonRespository;

@Service
public class LifeService {
    @Autowired
    private final PokemonRespository pokemonRespository;

    public LifeService(PokemonRespository pokemonRespository) {
        this.pokemonRespository = pokemonRespository;
    }

    public List<Pokemon> getAll() {
        return pokemonRespository.findAllByOrderByLifeRankDesc();
    }

    public List<Pokemon> getTop() {
        return pokemonRespository.findTop25ByOrderByLifeRankDesc();
    }

    public Optional<Pokemon> increaseLifeRank(Integer id) {
        Optional<Pokemon> pok = pokemonRespository.findById(id);
        if (pok.isPresent()) {
            pokemonRespository.incrementLife(id);
            pok.get().setLifeRank(pok.get().getLifeRank() + 1);
            return pok;
        }
        return null;
    }

}
