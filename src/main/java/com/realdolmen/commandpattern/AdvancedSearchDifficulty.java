package com.realdolmen.commandpattern;

import com.realdolmen.domain.Difficulty;
import com.realdolmen.domain.Game;
import com.realdolmen.services.DifficultyServiceImpl;
import com.realdolmen.services.GameServiceImpl;
import com.realdolmen.services.Service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AdvancedSearchDifficulty implements Command {
    private final Service<Difficulty> difficultyService = new DifficultyServiceImpl();
    private final Service<Game> gameService = new GameServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() throws Exception {
        System.out.println("---- List of difficulties -----");
        List<Difficulty> difficulties = difficultyService.findAll();
        difficulties.forEach(difficulty -> System.out.println("id= " + difficulty.getId() + " difficulty= " + difficulty.getDifficultyName()));
        System.out.println("---------");

        System.out.print("Choose a minimum difficulty lvl: ");
        int minDifficulty = scanner.nextInt();
        List<Difficulty> minimumDifficultyList = difficulties.stream().filter(difficulty -> difficulty.getId() >= minDifficulty).collect(Collectors.toList());
        gameService.findByDifficulty(minimumDifficultyList).forEach(game -> System.out.printf("Game name= %-50s | difficulty= %s %n", game.getGameName(), game.getDifficulty().getDifficultyName()));
    }
}
