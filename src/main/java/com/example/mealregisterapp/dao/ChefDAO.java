package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.NotFoundException;
import com.example.mealregisterapp.model.ChefModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChefDAO {


    public static ChefModel retrieveChefByEmail(String email) {

        ChefModel chefModel = null;
        try {
            Connection connection = SingletonConnection.getInstance();
            PreparedStatement preparedStatement = connection.prepareStatement(Queries.selectChefByEmail(email));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.first()) {
                throw new NotFoundException("No chefs found with the email: " + email);
            }

            resultSet.first();
            do {
                int chefId = resultSet.getInt("chefId");
                chefModel = setChefInfo(chefId, email, resultSet);

            } while (resultSet.next());
            resultSet.close();
        } catch (SQLException | NotFoundException e) {
            e.printStackTrace();
        }
        return chefModel;
    }

    private static ChefModel setChefInfo(int chefId, String email, ResultSet resultSet) throws SQLException {

        ChefModel chefModel = null;
        String chefName = resultSet.getString("name");
        String chefSurname = resultSet.getString("surname");
        String username = resultSet.getString("username");
        String webSite = resultSet.getString("website");
        if (username != null) {
            chefModel = new ChefModel(chefId, email, chefName, chefSurname, webSite, username);
        } else {
            chefModel = new ChefModel(chefId, email, chefName, chefSurname, webSite);
        }

        return chefModel;
    }
}
