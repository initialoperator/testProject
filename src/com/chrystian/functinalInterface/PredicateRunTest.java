package com.chrystian.functinalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PredicateRunTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            numbers.add(new Random().nextInt());
        }
        numbers.forEach(System.out::println);

        System.out.println("\n\nFull list print done! \n\n");

        Double average = numbers.stream()
                .mapToDouble(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("Average is: " + average + "\n\n");
        numbers.stream()
                .filter((n) -> n.doubleValue() > average)
                .forEach(System.out::println);
    }
}
