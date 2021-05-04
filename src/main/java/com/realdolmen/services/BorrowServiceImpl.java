package com.realdolmen.services;

import com.realdolmen.domain.Borrow;
import com.realdolmen.domain.Borrower;
import com.realdolmen.domain.Game;
import com.realdolmen.repositories.BorrowRepository;
import com.realdolmen.repositories.BorrowerRepository;
import com.realdolmen.repositories.GameRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BorrowServiceImpl implements Service<Borrow> {

    private final BorrowRepository borrowRepository = new BorrowRepository();
    private final GameRepository gameRepository = new GameRepository();
    private final BorrowerRepository borrowerRepository = new BorrowerRepository();


    @Override
    public List<Borrow> findAll() throws Exception {
        List<Borrow> borrowList = borrowRepository.findAll();
        for (Borrow borrow : borrowList) {
            Optional<Game> game = gameRepository.findByBorrowId(borrow.getId());//ByBorrowId not BorrowerId !!
            game.ifPresent(borrow::setGame); //If game is found so it's present, set the game on borrow
            Optional<Borrower>  borrower = borrowerRepository.findByBorrowId(borrow.getId());
            borrower.ifPresent(borrow::setBorrower);// If borrower is present, set the borrower on borrow
        }
        Collections.sort(borrowList, Comparator.comparing(o -> o.getBorrower().getBorrowerName()));
        Collections.sort(borrowList, Comparator.comparing(Borrow::getBorrowDate));
        return borrowList;
    }
}
