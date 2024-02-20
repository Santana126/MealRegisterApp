package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.CheckLoginException;
import com.example.mealregisterapp.exception.NotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private LoginDAO() {


    }

    public static int checkLogin(String email, String password) throws CheckLoginException {

        int type = 0;

        try {

            connection = SingletonConnection.getInstance();

            // Prendo il result set della query, lo faccio usando la classe Queries in modo tale da creare indipendenza tra il db e il modo in cui vengono formulate le query
            preparedStatement = connection.prepareStatement(Queries.checkLogin(email, password));
            ResultSet resultSet = preparedStatement.executeQuery();



            // Verifico se il result set è vuoto e nel caso lancio un’eccezione
            if (!resultSet.next()) {
                throw new NotFoundException("No user found with " + email);
            }


            type = resultSet.getInt(1);

            // Clean-up dell'ambiente
            resultSet.close();

        } catch (NotFoundException | SQLException e) {
            throw new CheckLoginException(e.getMessage());
        }
        return type;
    }


}
