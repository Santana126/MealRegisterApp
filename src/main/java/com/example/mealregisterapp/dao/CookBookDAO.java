package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.CookBookBean;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CookBookDAO {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public CookBookDAO() {
        connection = SingletonConnection.getInstance();
    }

    public CookBookBean loadCookBookPreview(){
        return new CookBookBean();
    }
}
