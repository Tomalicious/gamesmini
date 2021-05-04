package com.realdolmen.commandpattern;

import com.realdolmen.domain.Borrow;
import com.realdolmen.domain.Borrower;
import com.realdolmen.services.BorrowServiceImpl;
import com.realdolmen.services.BorrowerServiceImpl;
import com.realdolmen.services.Service;

import java.time.LocalDate;
import java.util.Scanner;

public class ShowBorrowedGames implements Command {
    private Service<Borrow> borrowService = new BorrowServiceImpl();
    private Service<Borrower> borrowerService = new BorrowerServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() throws Exception {
        System.out.println("---- Result -----");
        borrowService.findAll().forEach(borrow -> {
            LocalDate borrowDate = borrow.getBorrowDate();
            LocalDate returnDate = borrow.getReturnDate();
            String format = "Name= %-50s | Borrowers name=%-30s | Borrow date= %tD | Return date= %tD";
            System.out.format(format + "%n", borrow.getGame().getGameName(), borrow.getBorrower().getBorrowerName(), borrowDate, returnDate);
        });
        System.out.println("---------");
        System.out.print("Do you want to search for a borrower? (y/n): ");
        if (scanner.next().equals("y")) {
            System.out.print("Partially type in the name of the borrower:");
            borrowerService.findByName(scanner.next()).forEach(System.out::println);
        }
    }
}
