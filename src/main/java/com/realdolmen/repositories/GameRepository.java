package com.realdolmen.repositories;

import com.realdolmen.domain.Category;
import com.realdolmen.domain.Difficulty;
import com.realdolmen.domain.Game;
import com.realdolmen.exceptions.NotFoundException;
import org.w3c.dom.ls.LSInput;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class GameRepository {

    public Game findById(int id) throws NotFoundException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id where g.id = ? ");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return createFullGameObject(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException("Game not found!");
        }
    }

    public List<Game> findByName(String name) throws NotFoundException {
        List<Game> games = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id where g.game_name like ? ");
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                games.add(createFullGameObject(resultSet));
            }
            if (games.isEmpty()) {
                throw new NotFoundException("No games are found!");
            }
            return games;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Game> findAll() throws NotFoundException {
        List<Game> games = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id order by g.game_name asc ");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                games.add(createFullGameObject(resultSet));
            }
            if (games.isEmpty()) {
                throw new NotFoundException("No games are found!");
            }
            return games;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Optional<Game> findByBorrowId(int id) throws NotFoundException {
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id inner join borrow as b on b.game_id = g.id where b.id = ? ");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return Optional.ofNullable(createFullGameObject(resultSet));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Game> findByDifficulty(List<Difficulty> minimumDifficultyList) throws NotFoundException {
        List<Game> games = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(dynamicallyBuildSqlWithInClause(minimumDifficultyList));
            for (int i = 0; i < minimumDifficultyList.size(); i++) {
                preparedStatement.setString(i + 1, minimumDifficultyList.get(i).getDifficultyName());
            }
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                games.add(createFullGameObject(resultSet));
            }
            if (games.isEmpty()) {
                throw new NotFoundException("No games are found!");
            }
            return games;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private String dynamicallyBuildSqlWithInClause(List<Difficulty> minimumDifficultyList) {
        StringBuilder stringBuilder = new StringBuilder("select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id where d.difficulty_name in (");
        String collect = minimumDifficultyList.stream().map(difficulty -> "?").collect(Collectors.joining(","));

        stringBuilder.append(collect).append(") order by g.game_name asc");
        return stringBuilder.toString();
    }

    private Game createFullGameObject(ResultSet resultSet) throws SQLException {
        return Game.builder()
                .id(resultSet.getInt("g.id"))
                .gameName(resultSet.getString("game_name"))
                .editor(resultSet.getString("editor"))
                .author(resultSet.getString("author"))
                .age(resultSet.getString("age"))
                .yearEdition(resultSet.getInt("year_edition"))
                .minPlayers(resultSet.getInt("min_players"))
                .maxPlayers(resultSet.getInt("max_players"))
                .category(new Category(resultSet.getInt("c.id"), resultSet.getString("category_name")))
                .playDuration(resultSet.getString("play_duration"))
                .difficulty(new Difficulty(resultSet.getInt("d.id"), resultSet.getString("difficulty_name")))
                .price(resultSet.getDouble("price"))
                .image(resultSet.getString("image"))
                .build();
    }


}
