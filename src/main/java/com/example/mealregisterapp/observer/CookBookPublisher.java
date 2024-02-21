package com.example.mealregisterapp.observer;

import java.util.List;

public class CookBookPublisher {

    private List<Subscriber> subscribers;

    public void notifySubscribers(){
        for (Subscriber sub :
                subscribers) {
            sub.update();
        }
    }

    public void subscribe(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }
}
