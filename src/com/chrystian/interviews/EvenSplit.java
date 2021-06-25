package com.chrystian.interviews;

import java.util.Arrays;
import java.util.stream.IntStream;

public class EvenSplit {
	public static void main(String[] args) {
		int[] array = {12, 7, 6, 7, 6};
		EvenSplit sol = new EvenSplit();
		boolean result = sol.balancedSplitExists(array);
		System.out.println(result);
	}
  boolean balancedSplitExists(int[] arr) {
	    // Write your code here
	  
	    Arrays.sort(arr);
	    int sum = IntStream.of(arr).sum();
	    int firstHalf =  arr[0];
	    int secondHalf = sum - firstHalf;
	    for(int i = 1; i < arr.length; i++) {
	    	if(firstHalf == secondHalf && arr[i-1] < arr[i])
	    		return true;
	    	firstHalf += arr[i];
	    	secondHalf -= arr[i];
	    }
	    return false;
	 }
}
