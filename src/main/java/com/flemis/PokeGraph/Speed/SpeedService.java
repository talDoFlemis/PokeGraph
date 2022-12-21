package com.flemis.PokeGraph.Speed;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flemis.PokeGraph.DTO.Pokemon;
import com.flemis.PokeGraph.Repositories.PokemonRespository;

@Service
public class SpeedService {
    @Autowired
    private final PokemonRespository pokemonRespository;

    public SpeedService(PokemonRespository pokemonRespository) {
        this.pokemonRespository = pokemonRespository;
    }

    public List<Pokemon> getAll() {
        return pokemonRespository.findAllByOrderBySpdRankDesc();
    }

    public List<Pokemon> getTop() {
        return pokemonRespository.findTop25ByOrderBySpdRankDesc();
    }

    public Optional<Pokemon> increaseSpeedRank(Integer id) {
        Optional<Pokemon> pok = pokemonRespository.findById(id);
        if (pok.isPresent()) {
            pokemonRespository.incrementSpeed(id);
            pok.get().setSpdRank(pok.get().getSpdRank() + 1);
            return pok;
        }
        return null;
    }

}
