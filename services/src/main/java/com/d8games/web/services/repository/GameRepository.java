package com.d8games.web.services.repository;

import com.d8games.web.services.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {

    @Query(
    "SELECT g " +
    "FROM Game g " +
    "ORDER BY g.gameReleaseDate")
    List<Game> getAllGames();

    Game getGameByGameId(String gameId);
}
