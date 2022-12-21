package com.flemis.PokeGraph.Life;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flemis.PokeGraph.DTO.Pokemon;

@RestController
@RequestMapping("/api/life")
public class LifeController {
    @Autowired
    private final LifeService lifeService;

    public LifeController(LifeService lifeService) {
        this.lifeService = lifeService;
    }

    @GetMapping
    public List<Pokemon> getAll() {
        return lifeService.getAll();
    }

    @GetMapping("/top")
    public List<Pokemon> getTop() {
        return lifeService.getTop();
    }

    @PatchMapping("{id}")
    public ResponseEntity<String> increaseLife(@PathVariable Integer id) {
        Optional<Pokemon> pok = lifeService.increaseLifeRank(id);
        if (pok.isPresent()) {
            return ResponseEntity.ok().body("Updated life with success");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pokemon not found");
    }

}
