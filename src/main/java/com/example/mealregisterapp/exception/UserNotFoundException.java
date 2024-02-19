package com.example.mealregisterapp.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("\n**************************************\nUser not found.");
    }
}
