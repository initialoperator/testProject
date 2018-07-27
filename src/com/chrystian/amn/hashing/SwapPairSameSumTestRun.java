package com.chrystian.amn.hashing;

import java.util.Arrays;
import java.util.Scanner;

public class SwapPairSameSumTestRun {
    /*
    * https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal/0
    *
Given two arrays of integers, write a program to check if a pair of values (one value from each array) exists such that swapping the elements of the pair will make the sum of two arrays equal.
Input:
First line of input contains a single integer T which denotes the number of test cases. T test cases follows. First line of each test case contains two space separated integers N and M. Second line of each test case contains N space separated integers denoting the elements of first array. Third line of each test case contains M space separated integers denoting the elements of second array.

Output:
For each test case, print 1 if there exists any such pair otherwise print -1.

Example:
Input:
2
6 4
4 1 2 1 1 2
3 6 3 3
4 4
5 7 4 6
1 2 3 8
Output:
1
1


    * */

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();//T =  # of test cases
//        int[] lengthArray = new int[t];
//        int[][] numberArrays = new int[t][];
//        for(int i = 0; i < t; i++){
//            lengthArray[i] = sc.nextInt();
//        }
//        sc.nextLine();
//        for(int i = 0; i < t; i++){
//            String input = sc.nextLine();
//            String[] split = input.split("\\s");
//            numberArrays[i] = Arrays.stream(split).map(str -> {
//                return (new Integer(str)).intValue();
//            })
//                    .mapToInt(Integer::intValue).toArray();
//        }
//        for (int[] array : numberArrays){
//            System.out.println("length of the array is: " + array.length);
//        }
        //finish testing


        String s = "WElcome to my dad's place";
        String[] tokens = s.split("\\s|\\'");
        System.out.println(tokens.length);
        for(String token : tokens)
            System.out.println(token);
    }
}
