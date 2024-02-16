package com.example.mealregisterapp.model;

import com.example.mealregisterapp.exception.CookBookDescriptionAlreadyExist;

import java.util.ArrayList;
import java.util.List;

public class CookBook {

    private String title;

    private Chef author;

    private String description;

    private List<Recipe> recipes;

    private List<CookBookType> types;

    public CookBook() {
        this.recipes = new ArrayList<>();
        this.types = new ArrayList<>();
    }
    public CookBook(String title,Chef author) {
        this.title = title;
        this.author = author;
        this.recipes = new ArrayList<>();
        this.types = new ArrayList<>();
    }
    public void addRecipe(Recipe recipe){
        this.recipes.add(recipe);
    }

    public void insertDescription(String text) throws CookBookDescriptionAlreadyExist {
        if (this.description.isEmpty()){
            this.description = text;
        }
        else{
            throw new CookBookDescriptionAlreadyExist("Description Already Exist");
        }
    }

    public void modifyDescription(String text){
        this.description = text;
    }

    public void insertTag(CookBookType tag){
        this.types.add(tag);
    }

    public void removeTag(CookBookType tag){
        this.types.remove(tag);
    }


}
