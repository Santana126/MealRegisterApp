package com.example.mealregisterapp.utils;

public class Printer {
    private Printer(){}
    public static void printMessage(String message){
        System.out.println(message);
    }
    public static void printPageTitle(String message){
        System.out.println("--------------------------------");
        System.out.println("------" + message + "------");
        System.out.println("--------------------------------");
    }
}