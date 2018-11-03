package com.d8games.web.services.controller;

import com.d8games.web.services.model.entity.Game;
import com.d8games.web.services.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services/controller/game")
@SuppressWarnings("unused")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping(value = "/getAll")
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @GetMapping(value = "/getById")
    public Game getById(@RequestParam String id) {
        return gameService.getById(id);
    }

    @PutMapping(value = "/save")
    public String save(@RequestParam String gameName, @RequestParam String gameSummary,
                       @RequestParam String gameDescription) {
        Game game = new Game();

        game.setGameName(gameName);
        game.setGameSummary(gameSummary);
        game.setGameDescription(gameDescription);

        gameService.save(game);
        return game.getGameId();
    }
}
