package com.example.mealregisterapp.app_controller;

import com.example.mealregisterapp.bean.BeanMeal;
import com.example.mealregisterapp.dao.MealDao;
import com.example.mealregisterapp.exception.SaveMealException;

import java.sql.SQLException;

public class MealRegisterController {

    public void saveMeal() throws SQLException, SaveMealException {
        MealDao mealDao = new MealDao();
        mealDao.saveMeal();
        BeanMeal.resetValues();
    }

}
