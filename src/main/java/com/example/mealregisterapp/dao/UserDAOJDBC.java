package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.NotFoundException;
import com.example.mealregisterapp.exception.RetriveUserCSVEXception;
import com.example.mealregisterapp.exception.RetriveUserException;
import com.example.mealregisterapp.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOJDBC implements UserDAO{

    private Connection connection;

    private PreparedStatement preparedStatement;
    @Override
    public UserModel retrieveUserById(int userId) throws NotFoundException, RetriveUserException {

        UserModel user = null;

        try {

            connection = SingletonConnection.getInstance();

            // Prendo il result set della query, lo faccio usando la classe Queries in modo tale da creare indipendenza tra il db e il modo in cui vengono formulate le query
            preparedStatement = connection.prepareStatement(Queries.selectUserById(userId));
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verifico se il result set è vuoto e nel caso lancio un’eccezione
            if (!resultSet.next()) {
                throw new NotFoundException("No user find with the id: " + userId);
            }


            do {
                String email = resultSet.getString("email");

                user = getUserInfo(userId, resultSet, email);


            } while (resultSet.next());

            // STEP 5.1: Clean-up dell'ambiente
            resultSet.close();

        }
        catch (SQLException e) {
            throw new RetriveUserException(e.getMessage());
        }

        return user;
    }

    @Override
    public UserModel retrieveUserByEmail(String email) throws NotFoundException, RetriveUserCSVEXception {
        UserModel user = null;

        try {

            connection = SingletonConnection.getInstance();

            // Prendo il result set della query, lo faccio usando la classe Queries in modo tale da creare indipendenza tra il db e il modo in cui vengono formulate le query
            preparedStatement = connection.prepareStatement(Queries.selectUserByEmail(email));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new NotFoundException("No user found with email: " + email);
            }

            do {

                int userId = resultSet.getInt("userId");

                user = getUserInfo(userId, resultSet, email);


            } while (resultSet.next());

            // Clean-up dell'ambiente
            resultSet.close();

        }
        catch (SQLException  e) {
            throw new RetriveUserCSVEXception(e.getMessage());
        }

        return user;
    }


    private UserModel getUserInfo(int userId, ResultSet resultSet, String email) throws SQLException {
        String username = resultSet.getString("username");
        return new UserModel(userId, email,username);
    }

}
