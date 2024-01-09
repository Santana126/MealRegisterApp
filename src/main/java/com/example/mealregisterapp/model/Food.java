package com.example.mealregisterapp.model;

public class Food {

    private String name;

    private float quantity;

    private int calories;

    private float carb;

    private float fat;

    private float protein;

    public Food(String name, float quantity, int calories, float carb, float fat, float protein) {
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
    }

    public Food(String name){
        this.name = name;
    }

    public String foodName() {
        return name;
    }

    public void setFoodName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Macro getMacro() {
        return new Macro(this.carb,this.fat,this.protein);
    }

    public void insertMacro(Macro macro) {
        this.carb = macro.getCarb();
        this.fat = macro.getFat();
        this.protein = macro.getProtein();
    }
}
