package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.exception.RetriveUserCSVEXception;
import com.example.mealregisterapp.model.UserModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserDAOCSV implements UserDAO {
    private static final String CSV_FILE_NAME = "src/main/res/Users.csv";
    private static final int USER_ID = 0;
    private static final int USERNAME = 1;
    private static final int EMAIL = 2;

    @Override
    public UserModel retrieveUserById(int userId) throws RetriveUserCSVEXception {
        UserModel user = null;
        File file = new File(CSV_FILE_NAME);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String row;
            String[] data;

            while ((row = bufferedReader.readLine()) != null) {
                data = row.split(",");
                if (data[USER_ID].equals(String.valueOf(userId))) {

                    String email = data[USER_ID];
                    user = getUserModule(email, data, userId);
                }
            }
        } catch (IOException e) {
            throw new RetriveUserCSVEXception(e.getMessage());
        }

        return user;
    }

    @Override
    public UserModel retrieveUserByEmail(String email) throws RetriveUserCSVEXception {
        UserModel user = null;
        File file = new File(CSV_FILE_NAME);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            String row;
            String[] data;

            while ((row = bufferedReader.readLine()) != null) {
                data = row.split(",");
                if (data[EMAIL].equals(email)) {

                    int userId = Integer.parseInt(data[USER_ID]);
                    user = getUserModule(email, data, userId);
                }
            }
        } catch (IOException e) {
            throw new RetriveUserCSVEXception(e.getMessage());
        }
        return user;
    }

    private UserModel getUserModule(String email, String[] data, int userId) {
        UserModel user;
        String username = data[USERNAME];
        user = new UserModel(userId, email, username);
        return user;
    }

}
