package com.realdolmen.repositories;

import com.realdolmen.domain.Borrow;
import com.realdolmen.exceptions.NotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepository {
    public List<Borrow> findAll() throws NotFoundException {
        List<Borrow> borrowList = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from borrow");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Date borrowDate = resultSet.getDate("borrow_date");
                Date returnDate = resultSet.getDate("return_date");
                Borrow borrow = Borrow.builder()
                        .id(resultSet.getInt("id"))
                        .borrowDate(borrowDate != null ? borrowDate.toLocalDate() : null) //Ternary if to check if date is not null, otherwise you get an NullPointerException on borrowDate.toLocalDate()
                        .returnDate(returnDate != null ? returnDate.toLocalDate() : null) //same here
                        .build();
                borrowList.add(borrow);
            }
            return borrowList;
        } catch (SQLException e) {
            throw new NotFoundException("borrowed items not found", e);
        }
    }
}
