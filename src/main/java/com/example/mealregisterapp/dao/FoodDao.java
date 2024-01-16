package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.exception.DaoConnectionException;
import com.example.mealregisterapp.model.Food;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao {
    private Connection connection;

    private PreparedStatement preparedStatement;


    public FoodDao() throws DaoConnectionException {
        try {
            connection = SingletonConnection.getInstance();
        }catch (SQLException e){
            throw new DaoConnectionException("FoodDao connessione fallita");
        }
    }

    public List<String> loadAvailableFoodList() throws SQLException {

        List<String> foodList = new ArrayList<>();

        preparedStatement = connection.prepareStatement("SELECT Name FROM Food ");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            foodList.add(resultSet.getString("Name"));
        }
        return foodList;
    }

    public Food loadFood(String name) throws SQLException {

        Food food = null;

        preparedStatement = connection.prepareStatement("SELECT Name FROM Food WHERE Name = ?");
        preparedStatement.setString(1,name);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            food = new Food(resultSet.getString("Name"));
        }

        return food;
    }
}
