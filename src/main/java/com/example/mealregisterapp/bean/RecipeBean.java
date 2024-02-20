package com.example.mealregisterapp.bean;

import java.util.List;

public class RecipeBean {

    private String name;

    private Integer recipeID;

    private Integer difficult;

    private Integer cost;

    private String description;

    private List<IngredientBean> ingredientBeanList;

    public RecipeBean(String name, Integer difficult, Integer cost, String description) {
        this.name = name;
        this.difficult = difficult;
        this.cost = cost;
        this.description = description;
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
        ingredientBeanList.add(ingredientBean);
    }

    public List<IngredientBean> getIngredientBeanList() {
        return ingredientBeanList;
    }
}
