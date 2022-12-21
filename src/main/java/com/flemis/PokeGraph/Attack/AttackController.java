package com.flemis.PokeGraph.Attack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flemis.PokeGraph.DTO.Pokemon;

@RestController
@RequestMapping("/api/attack")
public class AttackController {
    @Autowired
    private final AttackService attackService;

    public AttackController(AttackService attackService) {
        this.attackService = attackService;
    }

    @GetMapping
    public List<Pokemon> getAll() {
        return attackService.getAll();
    }

    @GetMapping(value = "top")
    public List<Pokemon> getTop25() {
        return attackService.getTop25();
    }

}
