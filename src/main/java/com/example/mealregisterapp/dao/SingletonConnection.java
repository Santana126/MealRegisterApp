package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.exception.DataBaseConnectionException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingletonConnection {
    private static Connection connection;

    private SingletonConnection() throws DataBaseConnectionException {
        dataBaseConnection();
    }

    private static void dataBaseConnection() throws DataBaseConnectionException {

        try (InputStream input = new FileInputStream("src/main/res/connection.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connection_url = properties.getProperty("DB_URL");
            String user = properties.getProperty("USER");
            String pass = properties.getProperty("PASS");

            connection = DriverManager.getConnection(connection_url, user, pass);
        } catch (IOException | SQLException e) {
            throw new DataBaseConnectionException(e.getMessage());
        }
        if (connection == null){
            System.exit(-1);
        }
    }

    public static Connection getInstance(){
        if (connection == null) {
            try {
                new SingletonConnection();
            } catch (DataBaseConnectionException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
