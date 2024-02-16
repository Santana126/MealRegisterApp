package com.example.mealregisterapp.observer;

import java.util.List;

public class CookBookPublisher {

    private List<Subscriber> subscribers;

    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber){
        if(this.subscribers.contains(subscriber)){
            this.subscribers.remove(subscriber);
        }
    }
}
