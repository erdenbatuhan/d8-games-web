package com.d8games.web.services.service;

import com.d8games.web.services.model.entity.Game;
import com.d8games.web.services.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("unused")
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll() {
        return gameRepository.getAllGames();
    }

    public Game getById(String id) {
        return gameRepository.getGameById(id);
    }

    public void save(Game game) {
        gameRepository.save(game);
    }
}
