package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.NotFoundException;
import com.example.mealregisterapp.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOJDBC implements UserDAO{

    private Connection connection;

    private PreparedStatement preparedStatement;
    @Override
    public UserModel retrieveUserById(int userId) throws NotFoundException {

        UserModel user = null;

        try {

            connection = SingletonConnection.getInstance();

            // Prendo il result set della query, lo faccio usando la classe Queries in modo tale da creare indipendenza tra il db e il modo in cui vengono formulate le query
            preparedStatement = connection.prepareStatement(Queries.selectUserById(userId));
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verifico se il result set è vuoto e nel caso lancio un’eccezione
            if (!resultSet.first()) {
                throw new NotFoundException("No user find with the id: " + userId);
            }

            // Riposiziono il cursore sul primo record del result set
            resultSet.first();
            do {
                String email = resultSet.getString("email");

                user = getUserInfo(userId, resultSet, email);


            } while (resultSet.next());

            // STEP 5.1: Clean-up dell'ambiente
            resultSet.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public UserModel retrieveUserByEmail(String email) throws NotFoundException {
        UserModel user = null;

        try {

            connection = SingletonConnection.getInstance();

            // Prendo il result set della query, lo faccio usando la classe Queries in modo tale da creare indipendenza tra il db e il modo in cui vengono formulate le query
            preparedStatement = connection.prepareStatement(Queries.selectUserByEmail(email));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) {
                throw new NotFoundException("No user found with email: " + email);
            }

            resultSet.first();
            do {

                int userId = resultSet.getInt("userId");

                user = getUserInfo(userId, resultSet, email);


            } while (resultSet.next());

            // Clean-up dell'ambiente
            resultSet.close();

        }
        catch (SQLException  e) {
            e.printStackTrace();
        }

        return user;
    }


    private UserModel getUserInfo(int userId, ResultSet resultSet, String email) throws SQLException {
        String username = resultSet.getString("username");
        return new UserModel(userId, email,username);
    }

}
