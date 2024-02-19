package com.example.mealregisterapp.dao;

import com.example.mealregisterapp.exception.NotFoundException;
import com.example.mealregisterapp.model.UserModel;

public interface UserDAO {

    UserModel retrieveUserById(int userId) throws NotFoundException;

    UserModel retrieveUserByEmail(String email) throws NotFoundException;

}
