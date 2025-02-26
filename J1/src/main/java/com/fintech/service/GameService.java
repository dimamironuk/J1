package com.example.project.service;

import com.example.project.entity.Game;
import com.example.project.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Optional<Game> getGameById(Long id) {
        return gameRepository.findById(id);
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game updateGame(Long id, Game gameDetails) {
        return gameRepository.findById(id).map(game -> {
            game.setTitle(gameDetails.getTitle());
            game.setPrice(gameDetails.getPrice());
            game.setGenre(gameDetails.getGenre());
            game.setReleaseDate(gameDetails.getReleaseDate());
            return gameRepository.save(game);
        }).orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
