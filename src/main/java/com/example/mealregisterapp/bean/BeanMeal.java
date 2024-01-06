package com.example.mealregisterapp.bean;

import com.example.mealregisterapp.model.Macro;
import com.example.mealregisterapp.model.MealType;

public class BeanMeal {

    private static String date;

    private static MealType mealType;
    private static Macro macro;

    private static int calories;

    public BeanMeal(String date, MealType mealType, Macro macro, int calories) {
        BeanMeal.date = date;
        BeanMeal.mealType = mealType;
        BeanMeal.macro = macro;
        BeanMeal.calories = calories;
    }

    public static String getDate() {
        return date;
    }

    public static void setDate(String newDate) {
        date = newDate;
    }

    public static MealType getMealType() {
        return mealType;
    }
    public static String getMealTypeString() {
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

    public static void setMealType(MealType newMealType) {
        mealType = newMealType;
    }

    public static Macro getMacro() {
        return macro;
    }

    public static void setMacro(Macro newMacro) {
        macro = newMacro;
    }

    public static int getCalories() {
        return calories;
    }

    public static void setCalories(int newCalories) {
        calories = newCalories;
    }

    public static void resetValues() {
        date = null;
        mealType = null;
        calories = 0;
        macro = null;
    }
}
