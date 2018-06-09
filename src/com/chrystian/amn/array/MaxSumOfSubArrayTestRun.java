package com.chrystian.amn.array;

import java.util.Scanner;

public class MaxSumOfSubArrayTestRun {
/*
* Some properties of this problem are:

If the array contains all non-positive numbers, then the solution is the number in the array with the smallest magnitude.
If the array contains all non-negative numbers, then the problem is trivial and the maximum sum is the sum of all the elements in the list.
An empty set[clarification needed] is not valid.
There can be multiple different sub-arrays that achieve the same maximum sum to the problem.

key idea about Kadane's algorithm is: if the max sum subarray lies in position k when the boundary is in i(initial) and n(end), what is the position of max sum subarray when the pointer is in n+1
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
            int[] numberArray = new int[length];
            for(int k = 0; k < length; k++){
                numberArray[k] = new Integer(array[k]);
            }
            int max = kadaneFromInternet(numberArray);
//            int max = findMaxSubarray(numberArray);
            System.out.println(max);
        }
    }

    public static int findMaxSubarray(int[] array){
        int max = 0;
        for(int i = 0; i < array.length; i++){
            int localMax = array[i];
             localMax = findMaxSubarray(array, i, i, localMax, localMax);
            if(localMax > max)
                max = localMax;
        }
        return max;
    }

    private static int findMaxSubarray(int[] array, int indexMax, int indexEnd, int currentMax, int currentSum){
        if(array == null || array.length == 0)
            return 0;
        if(array.length - indexEnd == 1)
            return currentMax;
        int newSum = currentSum + array[indexEnd+1];
        if (newSum > currentMax){
            return findMaxSubarray(array, indexEnd+1, indexEnd+1, newSum, newSum);
        }else{
            return findMaxSubarray(array, indexMax, indexEnd+1, currentMax, newSum);
        }
    }

    // this method is copy from the internet
    //this method can only find the max sum but not the array of the max sum. Because it only needs a number as the max, it can be really effiecient. O(n)
    //problem: this method doesn't accept negative number!!!!  it's not fully considered Kadane's algorithm!
    public static int kadaneFromInternet(int[] A)
    {
        // stores maximum sum sub-array found so far
        int maxSoFar = 0;
        // stores maximum sum of sub-array ending at current position
        int maxEndingHere = 0;
        // traverse the given array
        for (int i: A)
        {
            // update maximum sum of sub-array "ending" at index i (by adding
            // current element to maximum sum ending at previous index i-1)
            maxEndingHere = maxEndingHere + i;
            // if maximum sum is negative, set it to 0 (which represents
            // an empty sub-array)
            maxEndingHere = Integer.max(maxEndingHere, 0);
            // update result if current sub-array sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }


/*we can extend the method above:
* 1. find the subarray with max sum - not returing just a single number but an actual array
* 2. find the subarray with the most balanced A's and B's (or 0's and 1's)
* */

}