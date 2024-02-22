package com.example.mealregisterapp.model;

import com.example.mealregisterapp.bean.IngredientBean;

public class Ingredient {

    private String name;
    private Float quantity;
    private Macro macros;
    private Integer calories;

    public void info() {
        //not implemented yet

    }

    public Ingredient(IngredientBean ingredientBean) {
        this.name = ingredientBean.getName();
        this.quantity = ingredientBean.getQuantity();

    }

    public void updateQuantity(Float newQuantity) {
        this.quantity = newQuantity;
    }
}
