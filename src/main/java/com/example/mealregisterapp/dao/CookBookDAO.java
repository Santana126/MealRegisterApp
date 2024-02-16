package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.exception.DaoConnectionException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CookBookDAO {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public CookBookDAO() throws DaoConnectionException {
        try {
            connection = SingletonConnection.getInstance();
        }catch (SQLException e){
            throw new DaoConnectionException("CookBookDao connessione fallita");
        }
    }

    public CookBookBean loadCookBookPreview(){
        return new CookBookBean();
    }
}
