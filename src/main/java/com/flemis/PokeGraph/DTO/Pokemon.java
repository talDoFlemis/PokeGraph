package com.flemis.PokeGraph.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pokemon {
    @Id
    private Integer id;
    private String name;
    @Transient
    private String sprite;
    @Transient
    private String pokedex;
    private Integer attRank = 0;
    private Integer spdRank = 0;
    private Integer lifeRank = 0;

    public Pokemon(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pokemon(Integer id, String name, Integer attRank, Integer spdRank, Integer lifeRank) {
        this.id = id;
        this.name = name;
        this.attRank = attRank;
        this.spdRank = spdRank;
        this.lifeRank = lifeRank;
    }

    public String getSprite() {
        return String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%d.png",
                this.id);
    }

    public String getPokedex() {
        return String.format("https://www.pokemon.com/br/pokedex/%s",
                this.name);
    }
}
