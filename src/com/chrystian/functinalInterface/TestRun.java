package com.chrystian.functinalInterface;

import java.util.function.Consumer;

public class TestRun {
/*
* things to be tested:
* assigned a functional interface method to a variable for later execution
* use lambda expression to invoke a functional interface method.
* separate implementation for Functinoal Interface
* */
    public static void main(String[] args) {
        ForConsumer fc = new ForConsumer();
        Consumer<String> consumer = fc::consumerMethod;
        consumer.accept("Chris");

        Consumer<String> consumer2 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                fc.consumerMethod(s);
            }
        };
        consumer2.accept("James");

        Consumer<String> consumer3 = (String s) -> fc.consumerMethod(s);
        consumer3.accept("Matt");


        Consumer<String> cList = consumer.andThen(consumer2).andThen(consumer3);
        cList.accept("cluster");
    }
}
