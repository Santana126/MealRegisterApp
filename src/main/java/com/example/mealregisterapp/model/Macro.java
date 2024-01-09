package com.example.mealregisterapp.model;

public class Macro {

    private float carb;

    private float fat;

    private float protein;

    public Macro() {
    }

    public Macro(float carb, float fat, float protein) {
        this.carb = carb;
        this.fat = fat;
        this.protein = protein;
    }

    public float getCarb() {
        return carb;
    }

    public void setCarb(float carb) {
        this.carb = carb;
    }

    public float getFat() {
        return fat;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public float getProtein() {
        return protein;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }
}
