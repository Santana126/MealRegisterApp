package com.example.mealregisterapp.exception;

public class RecipeDaoException extends Exception {
    public RecipeDaoException(String message) {
        super("Recipe Dao error:" + message);
    }
}
