package com.realdolmen.commandpattern;

import com.realdolmen.domain.Game;
import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.services.GameServiceImpl;
import com.realdolmen.services.Service;

import java.util.List;
import java.util.Scanner;

public class ChooseGame implements Command {
    private Service<Game> gameService = new GameServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() throws NotFoundException {
        System.out.print("Choose a game by name to see more details: ");
        Game game = gameService.findByName(scanner.next()).get(0);
        System.out.println("---- Result -----");
        System.out.printf("Game name = %s %nEditor = %s %nAge = %s %nPrice = %.2f€%n", game.getGameName(), game.getEditor(), game.getAge(), game.getPrice());
        System.out.println("---------");
    }
}
