package com.example.mealregisterapp.model;

import com.example.mealregisterapp.exception.RecipeDescriptionException;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private String name;
    private String description;
    private Integer difficult;
    private Integer cost;
    private List<Food> ingredients;
    private NutritionFacts nutritionFacts;

    public Recipe() {
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Food ingredient){
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


}
