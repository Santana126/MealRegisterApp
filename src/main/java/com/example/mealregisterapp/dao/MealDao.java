package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.exception.SaveMealException;
import com.example.mealregisterapp.model.Food;
import com.example.mealregisterapp.model.Meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MealDao {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public MealDao() throws SQLException {
        connection = SingletonConnection.getInstance();
    }

    public void saveMeal(Meal mealToSave) throws SQLException, SaveMealException {

        preparedStatement = connection.prepareStatement("INSERT INTO Meal (Date, Type) VALUES (?, ?)");
        preparedStatement.setString(1, mealToSave.getDate());
        preparedStatement.setString(2, mealToSave.getMealTypeString());
        int rowAffected = preparedStatement.executeUpdate();
        if (rowAffected <= 0){
            throw new SaveMealException("Inserimento fallito");
        }

    }

    public Integer loadMealID(Meal meal) throws SQLException {

        preparedStatement = connection.prepareStatement("SELECT ID FROM Meal WHERE Meal.Date = ? AND Meal.Type = ?");
        preparedStatement.setString(1,meal.getDate());
        preparedStatement.setString(2,meal.getMealTypeString());

        ResultSet resultSet = preparedStatement.executeQuery();
        Integer result = null;

        while (resultSet.next()){
            result = resultSet.getInt("ID");

        }
        return result;
    }

    public void saveFoodIntoMeal(Meal meal, Food food) throws SQLException, SaveMealException {
        preparedStatement = connection.prepareStatement("INSERT INTO MealFood (MealID, FoodName) VALUES (?, ?)");
        preparedStatement.setInt(1,meal.getMealID());
        preparedStatement.setString(2,food.foodName());
        int rowAffected = preparedStatement.executeUpdate();
        if (rowAffected <= 0){
            throw new SaveMealException("Inserimento fallito");
        }
    }
}
