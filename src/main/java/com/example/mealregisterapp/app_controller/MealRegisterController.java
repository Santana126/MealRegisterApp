package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.BeanFood;
import com.example.mealregisterapp.bean.BeanMeal;
import com.example.mealregisterapp.dao.FoodDao;
import com.example.mealregisterapp.dao.MealDao;
import com.example.mealregisterapp.exception.SaveMealException;
import com.example.mealregisterapp.model.Food;
import com.example.mealregisterapp.model.Meal;
import com.example.mealregisterapp.model.MealType;

import java.sql.SQLException;
import java.util.List;

public class MealRegisterController {

    private Meal meal;

    public void saveMeal() throws SQLException, SaveMealException {
        MealDao mealDao = new MealDao();
        mealDao.saveMeal(meal);
        BeanMeal.resetValues();
    }

    public void createMeal(String date, MealType mealType) throws SQLException, SaveMealException {
        meal = new Meal(date, mealType);
        saveMeal();
    }

    public void addFoodToMeal(List<BeanFood> selectedFoodList) throws SQLException {
        for (BeanFood foodBean : selectedFoodList
        ) {
            FoodDao foodDao = new FoodDao();
            Food food = foodDao.loadFood(foodBean.getName());
            meal.updateMeal(food);
        }
    }

    public void mealResumeConfirmed() throws SQLException, SaveMealException {
        MealDao mealDao = new MealDao();
        List<Food> foodList = meal.getMealFoodList();
        for (Food food : foodList) {
            mealDao.saveFoodIntoMeal(meal, food);
        }
    }

    public void mealResume() {
        /*
        Show meal Resume TODO
         */
    }
}
