package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.dao.queries.Queries;
import com.example.mealregisterapp.exception.NotFoundException;
import com.example.mealregisterapp.exception.RetriveUserException;
import com.example.mealregisterapp.model.ChefModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChefDAO {
    private static Connection connection;

    private static PreparedStatement preparedStatement;

    private ChefDAO() {
        //Costruttore privato perché la classe contiene metodi statici
    }


    public static ChefModel retrieveChefByEmail(String email) throws RetriveUserException {

        ChefModel chefModel = null;
        try {
            connection = SingletonConnection.getInstance();
            preparedStatement = connection.prepareStatement(Queries.selectChefByEmail(email));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (!resultSet.next()) {
                throw new NotFoundException("No chefs found with the email: " + email);
            } else {
                int chefId = resultSet.getInt("chefId");
                chefModel = setChefInfo(chefId, email, resultSet);
            }
            resultSet.close();

        } catch (SQLException | NotFoundException e) {
            throw new RetriveUserException(e.getMessage());
        }
        return chefModel;
    }

    private static ChefModel setChefInfo(int chefId, String email, ResultSet resultSet) throws SQLException {

        String chefName = resultSet.getString("name");
        String chefSurname = resultSet.getString("surname");

        return new ChefModel(chefId, email, chefName, chefSurname, null, null);
    }
}
