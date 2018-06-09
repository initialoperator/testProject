package com.chrystian.amn.array;

import java.util.Scanner;

public class MaxSumOfSubArrayTestRun {
/*
* Some properties of this problem are:

If the array contains all non-positive numbers, then the solution is the number in the array with the smallest magnitude.
If the array contains all non-negative numbers, then the problem is trivial and the maximum sum is the sum of all the elements in the list.
An empty set[clarification needed] is not valid.
There can be multiple different sub-arrays that achieve the same maximum sum to the problem.

* */
    public static void main(String[] args) {
        /*use scanner: the first line of integer indicates how many test cases there are
        * then for each test case, there are 2 lines of input
        * the first integer input indicates the size of the array
        * the secfond input provides the array
        *
        * */

        Scanner scanner = new Scanner(System.in);
        int tcNum = scanner.nextInt();//test cases' number

        for(int i = 0; i < tcNum; i++){
            int length = scanner.nextInt();
            scanner.nextLine();
            String arrayLine = scanner.nextLine();//assuming each element from the input will be a number
            String[] array = arrayLine.split("\\s");
            Integer[] numberArray = new Integer[length];
            for(int k = 0; k < length; k++){
                numberArray[k] = new Integer(array[k]);
                System.out.println(array[k]);
            }


        }
    }



}