package com.realdolmen.commandpattern;

import com.realdolmen.domain.Game;
import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.services.GameServiceImpl;
import com.realdolmen.services.Service;

import java.util.List;
import java.util.Scanner;

public class ShowGamesAndChoose implements Command {
    private final Service<Game> gameService = new GameServiceImpl();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() throws NotFoundException {
        System.out.println("----List of games -----");
        gameService.findAll().forEach(game -> System.out.format("name: %-50s \t|  category: %-50s %n", game.getGameName(), game.getCategory().getCategoryName()));
        System.out.println("----End of list -----");
        System.out.print("Type a part of the game name, if you want to see more details: ");
        Game game = gameService.findByName(scanner.next()).get(0);
        System.out.println(game);
    }
}
