package com.example.mealregisterapp.model;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.IngredientBean;
import com.example.mealregisterapp.bean.RecipeBean;
import com.example.mealregisterapp.exception.RecipeDescriptionException;

import java.util.ArrayList;
import java.util.List;

public class Recipe {


    private int recipeId;
    private String name;
    private String description;
    private Integer difficult;
    private Integer cost;
    private List<Ingredient> ingredients;
    private NutritionFacts nutritionFacts;

    private Chef author;

    public Recipe() {
        this.ingredients = new ArrayList<>();
    }

    public Recipe(RecipeBean recipeBean){
        this.name = recipeBean.getName();
        this.recipeId = recipeBean.getRecipeId();
        if(recipeBean.getIngredientBeanList() != null) {
            for (IngredientBean ingredientBean : recipeBean.getIngredientBeanList()) {
                Ingredient ingredient = new Ingredient(ingredientBean);
                this.ingredients.add(ingredient);
            }
        }
        this.description = recipeBean.getDescription();
        this.cost = recipeBean.getCost();
        this.difficult = recipeBean.getDifficult();
    }

    public Recipe(RecipeBean recipeBean, ChefBean author){
        this.name = recipeBean.getName();
        for (IngredientBean ingredientBean: recipeBean.getIngredientBeanList()) {
            Ingredient ingredient = new Ingredient(ingredientBean);
            this.ingredients.add(ingredient);
        }
        this.description = recipeBean.getDescription();
        this.cost = recipeBean.getCost();
        this.difficult = recipeBean.getDifficult();
        this.author = new Chef(author);
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }

    public void insertDescription(String text) throws RecipeDescriptionException {
        if (this.description.isEmpty()){
            this.description = text;
        }else{
            throw new RecipeDescriptionException("Descrizione già esistente");
        }
    }

    public void modifyDescription(String text){
        this.description = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public Integer getDifficult() {
        return difficult;
    }

    public void setDifficult(Integer difficult) {
        this.difficult = difficult;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Chef getAuthor() {
        return author;
    }

    public void setAuthor(Chef author) {
        this.author = author;
    }
}
