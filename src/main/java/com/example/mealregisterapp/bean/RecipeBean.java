package com.example.mealregisterapp.bean;

import java.util.ArrayList;
import java.util.List;

public class RecipeBean {

    private String name;

    private Integer recipeId;

    private Integer difficult;

    private Integer cost;

    private String description;

    private List<IngredientBean> ingredientBeanList = new ArrayList<>();

    public RecipeBean(String name, Integer difficult, Integer cost, String description) {
        this.name = name;
        this.difficult = difficult;
        this.cost = cost;
        this.description = description;
    }

    public RecipeBean(String name, String description,int recipeId) {
        this.recipeId = recipeId;
        this.name = name;
        this.description = description;
    }

    public RecipeBean() {

    }

    public void seePreview(){
        //see some details of the Recipe
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addIngredient(IngredientBean ingredientBean){
        this.ingredientBeanList.add(ingredientBean);
    }

    public List<IngredientBean> getIngredientBeanList() {
        return ingredientBeanList;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }
}
