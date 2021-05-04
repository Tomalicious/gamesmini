package com.realdolmen.services;

import com.realdolmen.domain.Difficulty;
import com.realdolmen.domain.Game;
import com.realdolmen.repositories.GameRepository;

import java.util.List;

public class GameServiceImpl implements Service<Game> {

    private final GameRepository gameRepository = new GameRepository();

    @Override
    public Game findById(int id) throws Exception {
        return gameRepository.findById(id);
    }

    @Override
    public List<Game> findByName(String name) throws Exception {
        return gameRepository.findByName(name);
    }

    @Override
    public List<Game> findAll() throws  java.lang.Exception {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findByDifficulty(List<Difficulty> minimumDifficultyList) throws java.lang.Exception {
        return gameRepository.findByDifficulty(minimumDifficultyList);
    }
}
