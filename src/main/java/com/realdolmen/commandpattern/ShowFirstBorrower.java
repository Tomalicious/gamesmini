package com.realdolmen.commandpattern;

import com.realdolmen.domain.Borrower;
import com.realdolmen.exceptions.NotFoundException;
import com.realdolmen.services.BorrowerServiceImpl;
import com.realdolmen.services.Service;
import com.sun.deploy.util.StringUtils;

public class ShowFirstBorrower implements Command {
    private final Service<Borrower> borrowerService = new BorrowerServiceImpl();

    @Override
    public void execute() throws NotFoundException {
        System.out.println("---- Result -----");
        System.out.println(borrowerService.findById(1));
        System.out.println("---------");
    }
}
