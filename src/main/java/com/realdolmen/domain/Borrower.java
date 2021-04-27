package com.realdolmen.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Borrower extends BaseEntity {
    private String borrowerName;
    private String street;
    private String houseNumber;
    private String busNumber;
    private String postalCode;
    private String city;
    private String telephone;
    private String email;

    @Override
    public String toString() {
        String stringFormat = "borrowerName= %s" +
                " | street= %s" +
                " | houseNumber= %s" +
                " | busNumber= %s" +
                " | postalCode= %s" +
                " | city= %s" +
                " | telephone= %s" +
                " | email= %s";
        return String.format(stringFormat, borrowerName, street, houseNumber, busNumber, postalCode, city, telephone, email);
    }
}
