package com.example.mealregisterapp.model;

public class NutritionFacts {

    private Macro macro;

    private float calories;

    public NutritionFacts(Macro macro,float calories){
        this.calories = calories;
        this.macro = macro;
    }
}
