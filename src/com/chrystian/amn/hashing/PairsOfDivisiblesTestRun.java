package com.chrystian.amn.hashing;

import java.util.Arrays;
import java.util.Scanner;

public class PairsOfDivisiblesTestRun {
    /*
https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem/0
Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible by k.

Input:
The first line of input contains an integer T denoting the number of test cases. The T test cases follow. Each test case contains an integer n denoting the size of the array. The next line contains the n space separated integers forming the array. The last line contains the value of k.

Output:
Print "True" (without quotes) if given array can be divided into pairs such that sum of every pair is divisible by k or else "False" (without quotes).

Constraints:
1<=T<=100
2<=n<=10^5
1<=a[i]<=10^5
1<=k<=10^5

Example:
Input:
2
4
9 7 5 3
6
4
91 74 66 48
10

Output:
True
False
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//T =  # of test cases
        for(int i = 0; i < t; i++){
            int length = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();
            String[] split = input.split("\\s");
            int[] array = Arrays.stream(split).map(s -> new Integer(s)).mapToInt(Integer::intValue).toArray();
            int divisor = sc.nextInt();
            boolean result = isCompleteDivisible(array,divisor);
            System.out.println(result);
        }
    }
    private static boolean isCompleteDivisible(int[] array, int divisor){

        return false;
    }
}
