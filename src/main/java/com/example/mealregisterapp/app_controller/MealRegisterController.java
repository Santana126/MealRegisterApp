package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.BeanFood;
import com.example.mealregisterapp.bean.BeanMeal;
import com.example.mealregisterapp.dao.FoodDao;
import com.example.mealregisterapp.dao.MealDao;
import com.example.mealregisterapp.exception.*;
import com.example.mealregisterapp.model.Food;
import com.example.mealregisterapp.model.Meal;
import com.example.mealregisterapp.model.MealType;

import java.sql.SQLException;
import java.util.List;

public class MealRegisterController {

    private Meal meal;

    public void saveMeal() throws SQLException, SaveMealFailedException {
        MealDao mealDao = new MealDao();
        mealDao.saveMeal(meal);
        BeanMeal.resetValues();
    }

    public void createMeal(String date, MealType mealType) {
        meal = new Meal(date, mealType);
    }

    public void addFoodToMeal(List<BeanFood> selectedFoodList) throws NoFoodFoundedException {
        for (BeanFood foodBean : selectedFoodList
        ) {

            Food food;
            try {
                FoodDao foodDao = new FoodDao();
                food = foodDao.loadFood(foodBean.getName());
            } catch (SQLException e) {
                throw new NoFoodFoundedException("Cibo non trovato");
            }
            meal.updateMeal(food);
        }
    }

    public void mealResumeConfirmed() throws SQLException, SaveFoodIntoMealFailedException {
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

    public List<String> loadAvailableFood() throws NotAvailableFoodFounded, DaoConnectionException {
        FoodDao foodDao = new FoodDao();
        List<String> resultList;
        try {
            resultList = foodDao.loadAvailableFoodList();
        } catch (SQLException e) {
            throw new NotAvailableFoodFounded("Nessun cibo disponibile");
        }
        return resultList;
    }
}
