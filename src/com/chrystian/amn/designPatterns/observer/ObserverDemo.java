package com.chrystian.amn.designPatterns.observer;

public class ObserverDemo {

    public static void main(String[] args){
        Subject s = new Subject();
        Observer ob = () -> {
            System.out.println("ob is performing");
        };
        s.subscribe(ob);

        s.next("");
    }
}
