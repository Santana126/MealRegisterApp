package com.example.mealregisterapp.bean;

import java.util.ArrayList;
import java.util.List;

public class CookBookBean {

    private ChefBean author;


    private String title;

    public List<RecipeBean> getRecipeBeanList() {
        return recipeBeanList;
    }

    private List<RecipeBean> recipeBeanList = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    private String description;


    private int difficult;



    public CookBookBean(){}

    public CookBookBean(ChefBean author, String title) {
        this.author = author;
        this.title = title;
    }

    public CookBookBean(ChefBean author, String title, String description) {
        this.author = author;
        this.title = title;
        this.description = description;
    }

    public CookBookBean(ChefBean author) {
        this.author = author;
    }

    public ChefBean getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDifficult() {
        return difficult;
    }

    public void setDifficult(int difficult) {
        this.difficult = difficult;
    }

    public void addRecipe(RecipeBean recipeBean) {
        this.recipeBeanList.add(recipeBean);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAuthor(ChefBean author) {
        this.author = author;
    }
}
