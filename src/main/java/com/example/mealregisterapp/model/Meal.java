package com.example.mealregisterapp.model;

import com.example.mealregisterapp.dao.MealDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Meal {


    private Integer ID;

    private String date;

    private MealType mealType;
    private Macro macro;

    private int calories;

    private List<Food> foodList;

    public Meal() {
    }

    public Meal(String date, MealType mealType, Macro macro, int calories) {
        this.date = date;
        this.mealType = mealType;
        this.macro = macro;
        this.calories = calories;
    }

    public Meal(String date, MealType mealType) {
        this.date = date;
        this.mealType = mealType;
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
        switch (this.mealType) {
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

    public void updateMeal(Food food) {
        if (foodList == null) {
            foodList = new ArrayList<>();
        }
        System.out.println(food.foodName());
        foodList.add(food);
        System.out.println(foodList.get(foodList.size()-1).foodName());

    }

    public Integer getID() throws SQLException {
        MealDao mealDao = new MealDao();
        ID = mealDao.loadMealID(this);
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public List<Food> getMealFoodList() {
        return foodList;
    }
}
