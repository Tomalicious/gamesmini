package com.realdolmen.repositories;

import com.realdolmen.domain.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepository {
    public Category findById(int id) throws Exception {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where id = ? ");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return new Category(resultSet.getInt("id"), resultSet.getString("category_name"));
        } catch (SQLException e) {
            throw new Exception("Game not found!");
        }
    }
}
