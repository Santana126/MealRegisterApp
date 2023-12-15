package com.example.mealregisterapp.model;

public class Meal {

    private String date;

    private MealType mealType;
    private Macro macro;

    private int calories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public Macro getMacro() {
        return macro;
    }

    public void setMacro(Macro macro) {
        this.macro = macro;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
