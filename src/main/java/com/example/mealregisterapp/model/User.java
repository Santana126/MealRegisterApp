package com.example.mealregisterapp.model;

import com.example.mealregisterapp.bean.PreferencesBean;
import com.example.mealregisterapp.observer.Subscriber;

import java.util.List;

public class User implements Subscriber {

    private String username;

    private PreferencesBean preferences;

    private List<String> inBox;


    public void addPreferences(List<CookBookType> newPreferences){
        for (CookBookType preference: newPreferences) {
            this.preferences.addPreference(preference);
        }
    }

    public void removePreferences(List<CookBookType> removePreferences){
        for (CookBookType preference: removePreferences
             ) {
            this.preferences.removePreference(preference);
        }
    }

    public PreferencesBean getPreferences() {
        return preferences;
    }

    @Override
    public void update() {
        inBox.add("New CookBook Published");
        //not implemented yet
        //Observer method
    }
}
