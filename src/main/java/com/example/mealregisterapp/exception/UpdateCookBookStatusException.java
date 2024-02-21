package com.example.mealregisterapp.exception;

public class UpdateCookBookStatusException extends Exception {
    public UpdateCookBookStatusException(String message) {
        super("Error: " + message);
    }
}
