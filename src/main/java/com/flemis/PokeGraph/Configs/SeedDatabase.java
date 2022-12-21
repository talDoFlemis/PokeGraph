package com.flemis.PokeGraph.Configs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.flemis.PokeGraph.DTO.Pokemon;
import com.flemis.PokeGraph.DTO.PokemonRespository;

@Component
public class SeedDatabase implements CommandLineRunner {

    @Autowired
    private final PokemonRespository pokemonRespository;

    public SeedDatabase(PokemonRespository pokemonRespository) {
        this.pokemonRespository = pokemonRespository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }

    private void loadUserData() {
        if (pokemonRespository.count() == 0) {
            Pokemon bul = new Pokemon(1, "bulba");
            Pokemon ch = new Pokemon(2, "charmander");
            Pokemon tubias = new Pokemon(2, "tubias", 23, 22, 21);
            pokemonRespository.saveAll(List.of(bul, ch, tubias));
        }
        System.out.println(pokemonRespository.count());
    }
}
