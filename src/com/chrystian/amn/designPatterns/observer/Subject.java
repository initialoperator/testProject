package com.chrystian.amn.designPatterns.observer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subject {

    private Set<Observer> observers = new HashSet<>();

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    public void next(String value){
        observers.stream().forEach(observer -> observer.perform());
    }
}
