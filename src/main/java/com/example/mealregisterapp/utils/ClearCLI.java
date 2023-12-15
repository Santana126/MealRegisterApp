package com.example.mealregisterapp.utils;

public class ClearCLI {

    private ClearCLI(){}
    public static void clear(){
        Printer.printMessage("\033[H\033[2J");
    }
}
