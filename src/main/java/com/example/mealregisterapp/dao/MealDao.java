package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.BeanMeal;
import com.example.mealregisterapp.exception.SaveMealException;
import com.example.mealregisterapp.model.Meal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MealDao {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public MealDao() throws SQLException {
        connection = SingletonConnection.getInstance();
    }

    public void saveMeal(BeanMeal beanMeal) throws SQLException, SaveMealException {

        Meal mealToSave = new Meal(beanMeal.getDate(), beanMeal.getMealType(), beanMeal.getMacro(), beanMeal.getCalories());

        preparedStatement = connection.prepareStatement("INSERT INTO Meal (Date, Type, Calories, Carbs, Fat, Protein) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, mealToSave.getDate());
        preparedStatement.setString(2, beanMeal.getMealTypeString());
        preparedStatement.setString(3, String.valueOf(mealToSave.getCalories()));
        preparedStatement.setString(4, String.valueOf(mealToSave.getMacro().getCarb()));
        preparedStatement.setString(5, String.valueOf(mealToSave.getMacro().getFat()));
        preparedStatement.setString(6, String.valueOf(mealToSave.getMacro().getProtein()));
        int rowAffected = preparedStatement.executeUpdate();
        if (!(rowAffected > 0)){
            throw new SaveMealException("Inserimento fallito");
        }
    }
}
