package com.example.mealregisterapp.observer;

import com.example.mealregisterapp.model.CookBookType;

public interface Subscriber {

     void update(CookBookType cookBookType);
}
