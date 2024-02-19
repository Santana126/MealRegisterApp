package com.example.mealregisterapp.utils;

public class Settings {

    private static String daoImpl;

    private Settings(){
        //Costruttore privato per metodi static
    }

    public static String daoConfig() {
        return daoImpl;
    }

    public static void setDaoImpl(String newDaoImpl) {
        daoImpl = newDaoImpl;
    }
}
