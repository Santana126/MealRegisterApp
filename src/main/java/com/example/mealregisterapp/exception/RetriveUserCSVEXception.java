package com.example.mealregisterapp.exception;

public class RetriveUserCSVEXception extends Exception {
    public RetriveUserCSVEXception(String message) {
        super("Retrive User from CSV failed: " + message);
    }
}
