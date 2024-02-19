package com.example.mealregisterapp.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingletonConnection {
    private static Connection connection;

    private SingletonConnection() throws SQLException {
        dataBaseConnection();
    }

    private static void dataBaseConnection() {
        String user;
        String password;
        String url;
        String driverClassName;

        try {
            Properties properties = loadProperties();
            user = properties.getProperty("USER");
            password = properties.getProperty("PASS");
            url = properties.getProperty("DB_URL");
            driverClassName = properties.getProperty("DRIVER_CLASS_NAME");

            Class.forName(driverClassName);

            connection = DriverManager.getConnection(url, user, password);

        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if (connection == null){
            System.exit(-1);
        }
    }

    public static Connection getInstance() throws SQLException {
        try {
            if (connection == null) {
                new SingletonConnection();
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return connection;
    }

    private static Properties loadProperties() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/res/connection.properties");
        properties.load(fileInputStream);
        return properties;
    }
}
