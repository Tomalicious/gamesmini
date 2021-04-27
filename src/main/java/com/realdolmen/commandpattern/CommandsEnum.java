package com.realdolmen.commandpattern;

import lombok.Getter;

@Getter //This is my invoker
public enum CommandsEnum {
    //TODO add more enums to choose from in the list of options
    SHOW_THE_FIRST_GAME_CAT(1, "Show the first game category", new ShowFirstGameCategory())
    , SHOW_THE_FIFTH_GAME(2, "Show the fifth game", new ShowFifthGame())
    , SHOW_THE_FIRST_BORROWER(3,"Show the first borrower", new ShowFirstBorrower())
    , CHOOSE_A_GAME(4, "Show a game of your choice", new ChooseGame())
    , SHOW_ALL_GAMES(5, "Show all games", new ShowAllGames())
    , SHOW_GAME_LIST_AND_CHOOSE_A_GAME(6, "Show a list of games and choose a game", new ShowGamesAndChoose())
    , SHOW_BORROWED_GAMES(7, "Show borrowed games", new ShowBorrowedGames())
    , ADVANCED_SEARCH_DIFFICULTY(8, "Advanced search: difficulty", new AdvancedSearchDifficulty());

    private final int optionId;
    private final String displayOption;
    private final Command command;

    CommandsEnum(int optionId, String displayOption, Command command) {
        this.optionId = optionId;
        this.displayOption = displayOption;
        this.command = command;
    }

    @Override
    public String toString() {
        return optionId + "." + displayOption;
    }
}
