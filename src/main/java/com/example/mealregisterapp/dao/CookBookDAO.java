package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.SaveCookBookException;
import com.example.mealregisterapp.model.CookBook;
import com.example.mealregisterapp.model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CookBookDAO {

    private Connection connection;

    private PreparedStatement preparedStatement;


    public CookBookDAO() {
        connection = SingletonConnection.getInstance();
    }

    public void saveCookBook(CookBook cookBook) throws SaveCookBookException {
        for (Recipe recipe :
                cookBook.getRecipes()) {
            try {
                preparedStatement = connection.prepareStatement(Queries.saveCookBook(cookBook, recipe));
                int rowAffected = preparedStatement.executeUpdate();
                if (rowAffected <= 0) {
                    throw new SaveCookBookException("Salvataggio CookBook fallito");
                }
            } catch (SQLException e) {
                throw new SaveCookBookException(e.getMessage());
            }
        }
    }

    public CookBookBean loadCookBookPreview() {
        return new CookBookBean();
    }
}
