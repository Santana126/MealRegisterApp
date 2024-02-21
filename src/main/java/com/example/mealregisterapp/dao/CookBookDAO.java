package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.bean.ChefBean;
import com.example.mealregisterapp.bean.CookBookBean;
import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.LoadCookBookException;
import com.example.mealregisterapp.exception.SaveCookBookException;
import com.example.mealregisterapp.exception.UpdateCookBookStatusException;
import com.example.mealregisterapp.model.CookBook;
import com.example.mealregisterapp.model.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<CookBookBean> loadAllCookBook(ChefBean chefBean) throws LoadCookBookException {

        List<CookBookBean> cookBookBeanList = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(Queries.loadChefCookBooks(chefBean.getChefID()));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                CookBookBean cookBookBean = new CookBookBean(chefBean,resultSet.getString("title"),resultSet.getString("description"));
                cookBookBeanList.add(cookBookBean);
            }
        } catch (SQLException e) {
            throw new LoadCookBookException(e.getMessage());
        }

        return cookBookBeanList;
    }

    public void markCookBookAsSelling(CookBookBean cookBookBean) throws UpdateCookBookStatusException {

        try {
            preparedStatement = connection.prepareStatement(Queries.sellCookBook(cookBookBean));
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected <= 0) {
                throw new UpdateCookBookStatusException("Update CookBook Status fallito");
            }
        } catch (SQLException | UpdateCookBookStatusException e) {
            throw new UpdateCookBookStatusException(e.getMessage());
        }
    }
}
