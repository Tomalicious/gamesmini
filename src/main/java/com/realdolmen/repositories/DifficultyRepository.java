package com.realdolmen.repositories;

import com.realdolmen.domain.Borrower;
import com.realdolmen.domain.Difficulty;
import com.realdolmen.exceptions.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DifficultyRepository {
    public List<Difficulty> findAll() throws NotFoundException {
        List<Difficulty> difficulties = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from difficulty");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                difficulties.add(new Difficulty(resultSet.getInt("id"), resultSet.getString("difficulty_name")));
            }
            if (difficulties.isEmpty()) {
                throw new NotFoundException("No borrowers are found!");
            }
            return difficulties;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
