package com.flemis.PokeGraph.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Pokemon {
    @Id
    private Integer id;
    private String name;
    @Transient
    private String sprite;
    private Integer attRank = 0;
    private Integer spdRank = 0;
    private Integer lifeRank = 0;

    public Pokemon() {
    }

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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSprite() {
        return String.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%d.png",
                this.id);
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public Integer getAttRank() {
        return this.attRank;
    }

    public void setAttRank(Integer attRank) {
        this.attRank = attRank;
    }

    public Integer getSpdRank() {
        return this.spdRank;
    }

    public void setSpdRank(Integer spdRank) {
        this.spdRank = spdRank;
    }

    public Integer getLifeRank() {
        return this.lifeRank;
    }

    public void setLifeRank(Integer lifeRank) {
        this.lifeRank = lifeRank;
    }

}
