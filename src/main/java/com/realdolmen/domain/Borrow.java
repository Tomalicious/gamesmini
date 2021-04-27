package com.realdolmen.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
public class Borrow extends BaseEntity {
    private Game game;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
