package com.example.mealregisterapp.exception;

public class LoadCookBookException extends Exception {
    public LoadCookBookException(String message) {
        super("Eroor in CookBookDAO: " + message);
    }
}
