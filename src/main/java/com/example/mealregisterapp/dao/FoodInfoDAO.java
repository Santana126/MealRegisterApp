package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.FoodBean;
import com.example.mealregisterapp.model.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FoodInfoDAO {
    private Connection connection;

    private PreparedStatement preparedStatement;


    public FoodInfoDAO() {
        connection = SingletonConnection.getInstance();
    }

    public FoodBean foodInfo(Ingredient ingredient){
        //Turn Ingredient into a foodBean with info about ingredient
        return new FoodBean();
    }

}
