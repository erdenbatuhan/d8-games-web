package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Game;
import com.d8games.web.services.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/game")
@SuppressWarnings("unused")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @GetMapping(value = "/get")
    public Game getById(@RequestParam String id) {
        return gameService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String name, @RequestParam String summary, @RequestParam String description) {
        Game game = new Game();

        game.setName(name);
        game.setSummary(summary);
        game.setDescription(description);

        gameService.save(game);
        return game.getId();
    }
}
