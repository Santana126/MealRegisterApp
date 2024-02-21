package com.example.mealregisterapp.exception;

public class SaveCookBookException extends Exception {
    public SaveCookBookException(String message) {
        super("Error: " + message);
    }
}
