package com.example.mealregisterapp.model;

public class Ingredient {

    private String name;
    private Float quantity;
    private Macro macros;
    private Integer calories;

    public void info(){

    }

    public void updateQuantity(Float newQuantity){
        this.quantity = newQuantity;
    }
}
