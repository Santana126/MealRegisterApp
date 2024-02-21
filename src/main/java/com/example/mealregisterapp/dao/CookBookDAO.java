package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.model.CookBook;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CookBookDAO {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public CookBookDAO() {
        connection = SingletonConnection.getInstance();
    }

    public void saveCookBook(CookBook cookBook){

    }

    public CookBookBean loadCookBookPreview(){
        return new CookBookBean();
    }
}
