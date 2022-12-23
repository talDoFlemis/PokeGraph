package com.flemis.PokeGraph.Configs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flemis.PokeGraph.DTO.Pokemon;
import com.flemis.PokeGraph.Repositories.PokemonRespository;

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
            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode node = mapper.readValue(
                        new File("src/main/resources/static/pokes.json"), JsonNode.class);
                List<Pokemon> arr = new ArrayList<>();

                node.get("data").forEach(ent -> arr.add(new Pokemon(ent.get("id").asInt(), ent.get("name").asText())));
                pokemonRespository.saveAll(arr);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(pokemonRespository.count());
    }
}