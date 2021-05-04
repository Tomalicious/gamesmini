package com.realdolmen.commandpattern;

import com.realdolmen.domain.Game;
import com.realdolmen.services.GameServiceImpl;
import com.realdolmen.services.Service;

public class ShowFifthGame implements Command {
    private Service<Game> gameService = new GameServiceImpl();

    @Override
    public void execute() throws Exception {
        System.out.println("---- Result -----");
        try {
            System.out.println(gameService.findById(5));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        System.out.println("---------");
    }
}
