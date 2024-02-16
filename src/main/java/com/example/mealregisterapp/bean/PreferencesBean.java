package com.example.mealregisterapp.bean;

import com.example.mealregisterapp.model.CookBookType;

import java.util.List;

public class PreferencesBean {

    private List<CookBookType> typePreferences;


    public boolean checkPreference(CookBookType preference){
        return (this.typePreferences).contains(preference);
    }

    public void addPreference(CookBookType preference){
        if(!checkPreference(preference)){
            this.typePreferences.add(preference);
        }
    }

    public void removePreference(CookBookType preference){
        if(checkPreference(preference)){
            this.typePreferences.remove(preference);
        }
    }

    public List<CookBookType> getTypePreferences(){
        return this.typePreferences;
    }

}
