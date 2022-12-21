package com.flemis.PokeGraph.DTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.lettuce.core.dynamic.annotation.Param;

public interface PokemonRespository extends JpaRepository<Pokemon, Integer> {

    // Attack Queries
    @Query("UPDATE Pokemon p set p.attRank = p.attRank + 1 where p.id = :id")
    public Pokemon incrementAttack(@Param("id") Integer id);

    public List<Pokemon> findAllByOrderByAttRankDesc();

    public List<Pokemon> findTop25ByOrderByAttRankDesc();

    // Speed Queries
    @Query("UPDATE Pokemon p set p.spdRank = p.spdRank + 1 where p.id = :id")
    public Pokemon incrementSpeed(@Param("id") Integer id);

    public List<Pokemon> findAllByOrderBySpdRankDesc();

    public List<Pokemon> findTop25ByOrderBySpdRankDesc();

    // Life Queries
    @Query("UPDATE Pokemon p set p.lifeRank = p.lifeRank + 1 where p.id = :id")
    public Pokemon incrementLife(@Param("id") Integer id);

    public List<Pokemon> findAllByOrderByLifeRankDesc();

    public List<Pokemon> findTop25ByOrderByLifeRankDesc();
}
