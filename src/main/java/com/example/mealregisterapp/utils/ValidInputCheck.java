package com.example.mealregisterapp.utils;

public class ValidInputCheck {

    private ValidInputCheck() {
        //private constructor for the static method
    }

    public static boolean checkInputDigit(String input){
        //Return true if the input is a single digit int
        if (input.length() > 1) {
            return false;
        }
        return input.matches("\\d+");
    }
}
