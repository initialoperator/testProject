package com.chrystian.amn.array;

import java.util.Arrays;
import java.util.stream.IntStream;

public class CanSwapOrNot {
    public static void main(String[] args){
        int[] a = { 1, 2, 2, 4, 5};
        int[] b = { 1, 3, 3, 4, 5};
        boolean result = canSwapToMakeEquaL(a, b);
        System.out.println(result);
    }
    private static boolean canSwapToMakeEquaL(int[] a, int[] b){
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        boolean[] exist = new boolean[1];
        IntStream.range(0, a.length).forEach(i -> {
            IntStream.range(0, b.length).forEach(k -> {
                if(sumA - a[i] + b[k] == sumB - b[k] + a[i])
                    exist[0] = true;
            });
        });
        return exist[0];
    }
}
