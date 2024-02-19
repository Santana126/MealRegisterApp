package com.example.mealregisterapp.exception;

public class NotFoundException extends Throwable {
    public NotFoundException(String message) {
        super("Error not found: " + message);
    }
}
