package com.flemis.PokeGraph.GraphQl;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.flemis.PokeGraph.DTO.Pokemon;
import com.flemis.PokeGraph.Repositories.PokemonRespository;

@Controller
@SchemaMapping(typeName = "Pokemon")
public class GraphQlController {
    private final PokemonRespository pokemonRespository;

    public GraphQlController(PokemonRespository pokemonRespository) {
        this.pokemonRespository = pokemonRespository;
    }

    @QueryMapping
    public List<Pokemon> atkList() {
        return pokemonRespository.findAllByOrderByAttRankDesc();
    }

    @QueryMapping
    public List<Pokemon> spdList() {
        return pokemonRespository.findAllByOrderBySpdRankDesc();
    }

    @QueryMapping
    public List<Pokemon> lifeList() {
        return pokemonRespository.findAllByOrderByLifeRankDesc();
    }

}
