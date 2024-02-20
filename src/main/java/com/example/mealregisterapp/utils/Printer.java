package com.example.mealregisterapp.utils;

public class Printer {
    private Printer() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPageTitle(String message) {
        printMessage("--------------------------------");
        printMessage("------" + message + "------");
        printMessage("--------------------------------");
    }

    public static void printYesOrNo() {
        printMessage("[Yes]/[No]");
    }

    public static void printEndOfPage(){
        printMessage("---------------------------");
        printMessage("---------------------------");
    }

    public static void error(String errorMessage) {
        System.err.println(errorMessage);
    }
}