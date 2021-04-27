package com.realdolmen.services;

import com.realdolmen.domain.Difficulty;
import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.repositories.DifficultyRepository;

import java.util.List;

public class DifficultyServiceImpl implements Service<Difficulty> {
    private final DifficultyRepository difficultyRepository = new DifficultyRepository();

    @Override
    public List<Difficulty> findByName(String name) throws NotFoundException {
        return difficultyRepository.findAll();
    }

    @Override
    public List<Difficulty> findAll() throws NotFoundException {
        return difficultyRepository.findAll();
    }
}
