package com.chrystian.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {

    public static void main(String[] args){
        List<MyCompare> list = new ArrayList<>();

        list.add(new MyCompare(17));
        list.add(new MyCompare(13));
        list.add(new MyCompare(39));
        list.add(new MyCompare(18));
        list.add(new MyCompare(1));

        List<MyCompare> newList = list.stream().sorted((a, b) -> {
            int result = a.getValue() - b.getValue();
            return result == 0 ? 0 : result/Math.abs(result);
        }).collect(Collectors.toList());
        newList.stream().forEach(System.out::println);
    }

    private static class MyCompare{

        public MyCompare(int value) {
            this.value = value;
        }

        private int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String toString(){
            return "" + value;
        }
    }

//    @FunctionalInterface
//    private static interface MyComparator<T> extends Comparator<T> {
//
//        @Override
//        public int compare(T a, T b){
//            return ((MyCompare)a).getValue() > ((MyCompare)b).getValue()? 1 : 0;
//        }
//    }
}
