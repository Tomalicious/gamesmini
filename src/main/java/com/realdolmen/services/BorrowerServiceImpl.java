package com.realdolmen.services;

import com.realdolmen.domain.Borrower;
import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.repositories.BorrowerRepository;

import java.util.List;

public class BorrowerServiceImpl implements Service<Borrower> {
    private final BorrowerRepository borrowerRepository = new BorrowerRepository();

    @Override
    public Borrower findById(int id) throws NotFoundException {
        return borrowerRepository.findById(id);
    }

    @Override
    public List<Borrower> findByName(String name) throws NotFoundException {
        return borrowerRepository.findByName(name);
    }
}
