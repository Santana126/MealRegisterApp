package com.example.mealregisterapp.exception;

public class SaveRecipeException extends Exception {
    public SaveRecipeException(String message) {
        super("Save Recipe Exception:" + message );
    }
}
