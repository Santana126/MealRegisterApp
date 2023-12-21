package com.example.mealregisterapp.bean;

import com.example.mealregisterapp.model.Macro;
import com.example.mealregisterapp.model.MealType;

public class BeanMeal {

    private String date;

    private MealType mealType;
    private Macro macro;

    private int calories;

    public BeanMeal(){}

    public BeanMeal(String date, MealType mealType, Macro macro, int calories) {
        this.date = date;
        this.mealType = mealType;
        this.macro = macro;
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public MealType getMealType() {
        return mealType;
    }
    public String getMealTypeString() {
        switch (mealType){
            case CENA -> {
                return "Cena";
            }
            case PRANZO -> {
                return "Pranzo";
            }
            case SPUNTINO -> {
                return "Spuntino";
            }
            case COLAZIONE -> {
                return "Colazione";
            }
        }
        return null;
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
