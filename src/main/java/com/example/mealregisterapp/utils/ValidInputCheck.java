package com.example.mealregisterapp.utils;

public class ValidInputCheck {

    public static boolean checkInputDigit(String input){
        if (input.length() > 1) {
            return false;
        }
        return input.matches("\\d+");
    }
}
