package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.exception.NotFoundException;
import com.example.mealregisterapp.exception.RetriveUserCSVEXception;
import com.example.mealregisterapp.exception.RetriveUserException;
import com.example.mealregisterapp.model.UserModel;

public interface UserDAO {

    UserModel retrieveUserById(int userId) throws NotFoundException, RetriveUserCSVEXception, RetriveUserException;

    UserModel retrieveUserByEmail(String email) throws NotFoundException, RetriveUserCSVEXception;

}
