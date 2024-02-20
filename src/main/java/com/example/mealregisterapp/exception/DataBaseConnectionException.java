package com.example.mealregisterapp.exception;

public class DataBaseConnectionException extends Exception {
    public DataBaseConnectionException(String message) {
        super("Database connection failed " + message);
    }
}
