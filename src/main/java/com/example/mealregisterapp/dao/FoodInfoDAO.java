package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.FoodBean;
import com.example.mealregisterapp.exception.DaoConnectionException;
import com.example.mealregisterapp.model.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FoodInfoDAO {
    private Connection connection;

    private PreparedStatement preparedStatement;


    public FoodInfoDAO() throws DaoConnectionException {
        try {
            connection = SingletonConnection.getInstance();
        }catch (SQLException e){
            throw new DaoConnectionException("FoodDao connessione fallita");
        }
    }

    public FoodBean foodInfo(Ingredient ingredient){

        return new FoodBean();
    }

}
