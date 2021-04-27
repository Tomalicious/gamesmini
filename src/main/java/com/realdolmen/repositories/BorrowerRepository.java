package com.realdolmen.repositories;

import com.realdolmen.domain.Borrower;
import com.realdolmen.exceptions.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class BorrowerRepository {
    public Borrower findById(int id) throws NotFoundException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from borrower where id = ? ");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return createBorrowerObject(resultSet);
        } catch (Exception e) {
            throw new NotFoundException("borrower not found");
        }
    }

    public Optional<Borrower> findByBorrowId(int id) throws NotFoundException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from borrower inner join borrow on borrower.id = borrow.borrower_id where borrow.id = ? ");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return Optional.ofNullable(createBorrowerObject(resultSet));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Borrower> findByName(String name) throws NotFoundException {
        List<Borrower> borrowers = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from borrower where borrower.borrower_name like ? ");
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                borrowers.add(createBorrowerObject(resultSet));
            }
            if (borrowers.isEmpty()) {
                throw new NotFoundException("No borrowers are found!");
            }
            return borrowers;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private Borrower createBorrowerObject(ResultSet resultSet) throws SQLException {
        return Borrower.builder()
                .id(resultSet.getInt("id"))
                .borrowerName(resultSet.getString("borrower_name"))
                .street(resultSet.getString("street"))
                .houseNumber(resultSet.getString("house_number"))
                .busNumber(resultSet.getString("bus_number"))
                .postalCode(resultSet.getString("postcode"))
                .city(resultSet.getString("city"))
                .telephone(resultSet.getString("telephone"))
                .email(resultSet.getString("email"))
                .build();
    }


}
