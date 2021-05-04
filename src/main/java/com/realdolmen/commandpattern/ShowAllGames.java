package com.realdolmen.commandpattern;

import com.realdolmen.domain.Game;
import com.realdolmen.services.GameServiceImpl;
import com.realdolmen.services.Service;

public class ShowAllGames implements Command {

    private final Service<Game> gameService = new GameServiceImpl();

    @Override
    public void execute() throws Exception {
        System.out.println("---- Result -----");
        gameService.findAll().forEach(game -> System.out.format("name: %-50s |  editor: %-50s | price: %.2f %n", game.getGameName(), game.getEditor(), game.getPrice()));
        System.out.println("---------");
    }
}
