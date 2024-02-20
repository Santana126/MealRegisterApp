package com.example.mealregisterapp.bean;

public class IngredientBean {

    private String name;
    private Float quantity;


    public IngredientBean(String name, Float quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public void updateQuantity(Float newQuantity){
        this.quantity = newQuantity;
    }
}
