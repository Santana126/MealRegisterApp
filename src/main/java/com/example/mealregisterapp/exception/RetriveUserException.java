package com.example.mealregisterapp.exception;

public class RetriveUserException extends Exception {
    public RetriveUserException(String message) {
        super("Retrive user error: "+ message);
    }
}
