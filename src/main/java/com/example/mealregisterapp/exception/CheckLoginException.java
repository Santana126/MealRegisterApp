package com.example.mealregisterapp.exception;

public class CheckLoginException extends Exception {
    public CheckLoginException(String message) {
        super("Login check failed " + message);
    }
}
