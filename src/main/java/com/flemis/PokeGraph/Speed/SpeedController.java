package com.flemis.PokeGraph.Speed;

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
@RequestMapping("/api/speed/")
public class SpeedController {
    @Autowired
    private final SpeedService speedService;

    public SpeedController(SpeedService speedService) {
        this.speedService = speedService;
    }

    @GetMapping
    public List<Pokemon> getAll() {
        return speedService.getAll();
    }

    @GetMapping("/top")
    public List<Pokemon> getTop() {
        return speedService.getTop();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> increaseSpeed(@PathVariable String id) {
        Optional<Pokemon> pok = speedService.increaseSpeedRank(Integer.parseInt(id));
        if (pok.isPresent()) {
            return ResponseEntity.ok().body("Rank updated with success");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The pokemon was not found");
    }

}
