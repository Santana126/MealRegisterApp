package com.example.mealregisterapp.exception;

public class EmailFormatException extends Exception {
    public EmailFormatException(String email) {
        super("'" + email +"' email non valida, inserire una nuova email");
    }
}
