package com.example.mealregisterapp.utils;

public class Settings {

    private static String daoImpl;

    public static String daoConfig() {
        return daoImpl;
    }

    public static void setDaoImpl(String newDaoImpl) {
        daoImpl = newDaoImpl;
    }
}
