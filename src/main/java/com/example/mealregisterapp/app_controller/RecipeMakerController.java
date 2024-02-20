package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.IngredientBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.cli_graphic_controller.RecipeMakerControllerCLI;
import com.example.mealregisterapp.dao.RecipeDAO;
import com.example.mealregisterapp.exception.SaveRecipeException;
import com.example.mealregisterapp.model.Recipe;
import com.example.mealregisterapp.session.Session;

public class RecipeMakerController {

    RecipeBean newRecipeBean;



    public void createNewRecipe() {
        RecipeMakerControllerCLI recipeMakerControllerCLI = new RecipeMakerControllerCLI(this);
        newRecipeBean = recipeMakerControllerCLI.createRecipe();

        recipeMakerControllerCLI.displayRecipeResume(newRecipeBean, Session.getCurrentSession().getChefBean());
        recipeMakerControllerCLI.recipeMenu();
        recipeMakerControllerCLI.addIngredientMenu(newRecipeBean);
    }


    public void showRecipeResume() {
        RecipeMakerControllerCLI recipeMakerControllerCLI = new RecipeMakerControllerCLI(this);
        recipeMakerControllerCLI.displayRecipeResume(newRecipeBean,Session.getCurrentSession().getChefBean());
    }

    public void insertNewIngredient() {
        RecipeMakerControllerCLI recipeMakerControllerCLI = new RecipeMakerControllerCLI(this);
        IngredientBean newIngredientBean = recipeMakerControllerCLI.selectIngredient();
        newRecipeBean.addIngredient(newIngredientBean);
    }

    public void viewIngredientOnRecipe() {
        RecipeMakerControllerCLI recipeMakerControllerCLI = new RecipeMakerControllerCLI(this);
        recipeMakerControllerCLI.displayRecipeIngredients(newRecipeBean);
    }

    public void confirmRecipe(){

        Recipe recipe = new Recipe(newRecipeBean,Session.getCurrentSession().getChefBean());
        RecipeDAO recipeDAO = new RecipeDAO();
        try {
            recipeDAO.saveRecipe(recipe);
        } catch (SaveRecipeException e) {
            RecipeMakerControllerCLI recipeMakerControllerCLI = new RecipeMakerControllerCLI(this);
            recipeMakerControllerCLI.recipeSaveError(e.getMessage());
        }

    }
}
