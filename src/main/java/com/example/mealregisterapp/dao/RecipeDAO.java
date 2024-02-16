package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.exception.DaoConnectionException;
import com.example.mealregisterapp.model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecipeDAO {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public RecipeDAO() throws DaoConnectionException {
        try {
            connection = SingletonConnection.getInstance();
        }catch (SQLException e){
            throw new DaoConnectionException("RecipeDao connessione fallita");
        }
    }

    public void saveRecipe(Recipe recipe){

    }

    public Recipe loadRecipe(String name){
        return new Recipe();
    }
}
