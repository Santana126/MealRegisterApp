package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.IngredientBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.dao.RecipeDAO;
import com.example.mealregisterapp.exception.SaveRecipeException;
import com.example.mealregisterapp.model.Recipe;
import com.example.mealregisterapp.session.Session;

public class RecipeMakerController {


    public void createNewRecipe(String name, int difficult, int cost, String description) {

        Session.getCurrentSession().getRecipeBean();
        Session.getCurrentSession().setRecipeBean(new RecipeBean(name, difficult, cost, description));
    }


    public RecipeBean takeRecipeResume() {
        return Session.getCurrentSession().getRecipeBean();
    }

    public void insertIngredientIntoRecipe(IngredientBean ingredientBean) {
        Session.getCurrentSession().getRecipeBean().addIngredient(ingredientBean);
    }

    public void confirmRecipe() throws SaveRecipeException {

        Recipe recipe = new Recipe(Session.getCurrentSession().getRecipeBean(), Session.getCurrentSession().getChefBean());
        RecipeDAO recipeDAO = new RecipeDAO();
        try {
            recipeDAO.saveRecipe(recipe);
        } catch (SaveRecipeException e) {
            throw new SaveRecipeException(e.getMessage());
        }

    }

    public ChefBean takeRecipeAuthor() {
        return Session.getCurrentSession().getChefBean();
    }

}
