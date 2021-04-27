package com.realdolmen.services;

import com.realdolmen.domain.Difficulty;
import com.realdolmen.domain.Game;
import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.repositories.GameRepository;

import java.util.List;

public class GameServiceImpl implements Service<Game> {

    private final GameRepository gameRepository = new GameRepository();

    @Override
    public Game findById(int id) throws NotFoundException {
        return gameRepository.findById(id);
    }

    @Override
    public List<Game> findByName(String name) throws NotFoundException {
        return gameRepository.findByName(name);
    }

    @Override
    public List<Game> findAll() throws NotFoundException {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findByDifficulty(List<Difficulty> minimumDifficultyList) throws NotFoundException {
        return gameRepository.findByDifficulty(minimumDifficultyList);
    }
}
