package com.realdolmen.commandpattern;

import com.realdolmen.domain.Game;
import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.services.GameServiceImpl;
import com.realdolmen.services.Service;

public class ShowFifthGame implements Command {
    private Service<Game> gameService = new GameServiceImpl();

    @Override
    public void execute() throws NotFoundException {
        System.out.println("---- Result -----");
        System.out.println(gameService.findById(5));
        System.out.println("---------");
    }
}
