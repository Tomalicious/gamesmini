package com.realdolmen.repositories;

import com.realdolmen.domain.Game;
import com.realdolmen.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRepositoryTest {

    private GameRepository gameRepository = new GameRepository();

    @Test
    void findById() throws NotFoundException {
        Game foundGame = gameRepository.findById(5);
        assertAll(() -> assertEquals("Abracadabra" ,  foundGame.getGameName()),
                () -> assertEquals("DaVinci Games" , foundGame.getEditor()),
                () -> assertEquals("Di Giorgio Domenico en Barletta Roberta", foundGame.getAuthor()),
                () -> assertEquals(2004, foundGame.getYearEdition()),
                () -> assertEquals("from 9 to 12y",foundGame.getAge()),
                () -> assertEquals(4, foundGame.getMinPlayers()),
                () -> assertEquals(6, foundGame.getMaxPlayers()),
                () -> assertEquals("16 min to 45 min", foundGame.getPlayDuration()),
                () -> assertEquals(10.00, foundGame.getPrice()),
                () -> assertEquals("abracadabra.jpg", foundGame.getImage()),
                () -> assertEquals(27, foundGame.getCategory().getId()),
                () -> assertEquals("strategy",foundGame.getCategory().getCategoryName()),
                () -> assertEquals(3, foundGame.getDifficulty().getId()),
                () -> assertEquals("average", foundGame.getDifficulty().getDifficultyName()));
    }
}