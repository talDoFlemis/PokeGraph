package com.flemis.PokeGraph.Attack;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flemis.PokeGraph.DTO.Pokemon;
import com.flemis.PokeGraph.DTO.PokemonRespository;

@Service
public class AttackService {
    @Autowired
    private final PokemonRespository pokemonRespository;

    public AttackService(PokemonRespository pokemonRespository) {
        this.pokemonRespository = pokemonRespository;
    }

    public List<Pokemon> getAll() {
        return pokemonRespository.findAllByOrderByAttRankAsc();
    }

    public List<Pokemon> getTop25() {
        return pokemonRespository.findTop25ByOrderByAttRankAsc();
    }

    public void increaseAttackRank(Integer id) {
        Optional<Pokemon> pok = pokemonRespository.findById(id);
        if (pok.isPresent()) {
            pokemonRespository.incrementAttack(id);
        }
    }

}
