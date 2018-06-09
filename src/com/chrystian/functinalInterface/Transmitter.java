package com.chrystian.functinalInterface;

@FunctionalInterface
public interface Transmitter<T> {
    T transmit(T t);

    default void muffle(T t){
        System.out.println(t.toString());
    }
}
