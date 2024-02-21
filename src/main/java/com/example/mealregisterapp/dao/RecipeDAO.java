package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.RecipeDaoException;
import com.example.mealregisterapp.exception.SaveRecipeException;
import com.example.mealregisterapp.model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public RecipeDAO() {
        connection = SingletonConnection.getInstance();
    }

    public void saveRecipe(Recipe recipe) throws SaveRecipeException {

        try {
            preparedStatement = connection.prepareStatement(Queries.saveRecipe(recipe));
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected <= 0) {
                throw new SaveRecipeException("Inserimento ricetta fallito");
            }
        } catch (SQLException e) {
            throw new SaveRecipeException(e.getMessage());
        }

    }

    public Recipe loadRecipe(String name) {
        //Take recipe from DB with the name of the recipe
        return new Recipe();
    }

    public List<RecipeBean> loadAllChefRecipe(ChefBean chefBean) throws RecipeDaoException {
        List<RecipeBean> recipeBeanList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(Queries.loadChefRecipe(chefBean.getChefID()));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                recipeBeanList.add(new RecipeBean(resultSet.getString("name"),resultSet.getString("description")));
            }

        } catch (SQLException e) {
            throw new RecipeDaoException(e.getMessage());
        }

        return recipeBeanList;

    }
}
