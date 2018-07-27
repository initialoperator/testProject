package com.chrystian.functinalInterface;

@FunctionalInterface
public interface DoublePredicate<T> {
//    private
    public boolean test(T arg1, T arg2);

}
