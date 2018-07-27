package com.chrystian.amn.scanners;

import java.util.Arrays;
import java.util.Scanner;

public class ScannerTestRun {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//T =  # of test cases
        int[] lengthArray = new int[t];
        int[][] numberArrays = new int[t][];
        for(int i = 0; i < t; i++){//this scanner groups the array length input togethter
            lengthArray[i] = sc.nextInt();
        }
        sc.nextLine();
        for(int i = 0; i < t; i++){
            String input = sc.nextLine();
            String[] split = input.split("\\s");
            numberArrays[i] = Arrays.stream(split).map(str -> {
                return (new Integer(str)).intValue();
            })
            .mapToInt(Integer::intValue).toArray();
        }
        for (int[] array : numberArrays){
            System.out.println("length of the array is: " + array.length);
        }
    }
}
