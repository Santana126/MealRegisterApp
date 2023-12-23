package com.example.mealregisterapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection connection;

    private static final String URL="jdbc:sqlite:src/main/resources/com/example/mealregisterapp/database/MealDataBase";

    private SingletonConnection() throws SQLException {
        DataBaseConnection();
    }

    private static void DataBaseConnection() throws SQLException {
        connection = DriverManager.getConnection(URL);
    }

    public static Connection getInstance() throws SQLException {
        try {
            if(connection == null){
                new SingletonConnection();
            }
        } catch (SQLException e) {
            throw new SQLException();

        }
        return connection;
    }


}
