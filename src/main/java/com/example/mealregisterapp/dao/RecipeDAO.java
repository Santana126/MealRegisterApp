package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.SaveRecipeException;
import com.example.mealregisterapp.model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecipeDAO {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public RecipeDAO() {
        connection = SingletonConnection.getInstance();
    }

    public void saveRecipe(Recipe recipe) throws SaveRecipeException {

        // Prendo il result set della query, lo faccio usando la classe Queries in modo tale da creare indipendenza tra il db e il modo in cui vengono formulate le query
        try {
            preparedStatement = connection.prepareStatement(Queries.saveRecipe(recipe));
            int rowAffected = preparedStatement.executeUpdate();
            if(rowAffected <= 0){
                throw new SaveRecipeException("Inserimento ricetta fallito");
            }
        } catch (SQLException e) {
            throw new SaveRecipeException(e.getMessage());
        }

    }

    public Recipe loadRecipe(String name){
        //Take recipe from DB with the name of the recipe
        return new Recipe();
    }
}
