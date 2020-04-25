package com.chrystian.java8.pratice.streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestRun {
    public static void main(String[] args) {
        // Creating a list of Strings
//        List<String> list = Arrays.asList("25", "225", "1000",
//                "20", "15");
//        List<Integer> listInt = Arrays.asList(10, 19, 20, 1, 2);
//        List<Integer> listRandom = new ArrayList<>();
//        Random r = new Random();
//        IntStream.range(0, 20).forEach(i -> {
//            listRandom.add(r.nextInt(100));
//        });
//
//        List<String> textes = Arrays.asList("public", "static", "StringJoiner", "Amazon", "Madamasca", "Son_Masayoshi");
////        findAny();
////        optional2();
////        System.out.println("for each order starts");
////        forEachOrder(listRandom);
////        System.out.println("for each starts:");
////        forEach(listRandom);
////        filter(listRandom);
////        flatMapToInt();
////        flatMap();
////        map();
////        loopSimulate();
//        filterString(textes);

//solution(5);
        int[] a = {-8, -4, 0 , 5, -4, 6};
        System.out.println(solution(a));
    }


    public static void solution(int N) {
        // write your code in Java SE 8
        IntStream.range(0, N-1).forEach((i) -> System.out.println("L"));
        IntStream.range(0, N).forEach((i) -> System.out.print("L"));
    }


    public static int solution(int[] A) {
        // write your code in Java SE 8
        int length = A.length;
        long resultL =  IntStream.range(0,length).flatMap(i -> {
            return IntStream.range(0, length).map(j -> {
                if(A[i] == A[j]&& i!=j)
                    return 1;
                else return 0;
            });
        }).filter(i -> i ==1).count();
        resultL = resultL/2;
        if(resultL > 1000000000L)
            return 1000000000;
        else
            return (int)resultL;
    }


    public static int solution1(int[] A) {
        // write your code in Java SE 8

        int length = A.length;


        int result = IntStream.range(0,length).flatMap(i -> {
            return IntStream.range(0, length).map(j -> {
                int vali = A[i];
                int valj = A[j];
                return vali + valj + Math.abs(i - j);
            });
        }).max().getAsInt();
        return  result;
    }

    private static void findAny(){
        List<String> list = Arrays.asList("Geeks", "for",
                "GeeksQuiz", "GFG");
        Optional<String> o = list.stream().findAny();
        System.out.println(o);
    }

    private static void optional2(){
        Optional<String> gender = Optional.of("male");
        String answer1 = "Yes";
        String answer2 = null;
        System.out.println("Optional of answer1: "+ Optional.ofNullable(answer1));
        System.out.println("Optional of answer2: "+ Optional.ofNullable(answer2));
        System.out.println("Get the true value of gender: "+ gender.get());
    }

    private static void forEachOrder(List<Integer> list){
        list.stream().parallel().forEachOrdered(System.out::println);
    }

    private static void forEach(List<Integer> list){
        list.stream().parallel().forEach(System.out::println);
    }

    private static void filter(List<Integer> list){
        System.out.println("before filtering: ");
        list.stream().parallel().forEachOrdered(System.out::println);

        System.out.println("After filtering: ");
        list.stream().parallel().filter(i -> i % 5 == 0).forEachOrdered(System.out::println);
    }

    private static void flatMapToInt() {
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("1", "2"),
                Arrays.asList("5", "6"),
                Arrays.asList("3", "4")
        );

        IntStream intStream =
                listOfLists.stream()
                        .flatMapToInt(childList ->
                                childList.stream()
                                        .mapToInt(Integer::new));
        //let's peek and find sum of the elements
        int sum = intStream.peek(System.out::println)
                .sum();
        System.out.println("sum: " + sum);
    }

    private static void map(){
        Stream<String> stringStream = Stream.of("1", "2", "3", "4");
        Set<Integer> intSet = stringStream.map(Integer::new).collect(Collectors.toSet());
        intSet.stream().parallel().forEach(System.out::println);

    }

    private static void flatMap(){
//        List evens = Arrays.asList(2, 4, 6);
//        List odds = Arrays.asList(3, 5, 7);
//        List primes = Arrays.asList(2, 3, 5, 7, 11);
        int[] evens = {2, 4, 6};
        int[] odds = {3, 5, 7};
        int[] primes = {2, 3, 5, 7, 11};
        List<Integer> integerList = Stream.of(evens, odds, primes).flatMap(list -> Arrays.stream(list).boxed()).map(i -> { //this boxed method is wicket
            return Integer.valueOf((int)i);
        }).map(i -> (Integer) i).collect(Collectors.toList());
        List<Integer> integerList2 = Stream.of(evens, odds, primes).flatMap(list -> Arrays.stream(list).mapToObj(i -> i)).collect(Collectors.toList());
        integerList2.stream().forEach(System.out::println);
    }
    private static void loopSimulate(){

        IntStream.range(0, 100).parallel().forEach(System.out::println);
    }
    private static void arrayToStream(){
        int[] primes = {2, 3, 5, 7, 11};
        Arrays.stream(primes).map(Integer::new).boxed().collect(Collectors.toList());
    }

    private static void filterString(List<String> textes){
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return isLengthTooShort(s, 8);
            }
        };
        textes.stream().parallel().filter(predicate).forEach(System.out::println);
    }
    private static boolean isLengthTooShort(String text, int threshold){
        return text.length() < threshold;
    }
}
