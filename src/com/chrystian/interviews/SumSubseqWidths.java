package com.chrystian.interviews;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumSubseqWidths {
	public static void main(String[] args) {
//		int[] array = {3, 9, 4, 0, 5, 2};
//		int[] array = {10, 9, 8, 8, 6, 5, 7};
		int[] array = {7,8,8,10,4};
		quickSort2(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
		
		Random r = new Random();
		int length = 10;
		int[] nums = new int[length];
//		IntStream.range(0, length).forEach(i -> nums[i] = r.nextInt(40));
//		
//		
//		IntStream.range(0, nums.length).forEach(i -> System.out.println(nums[i]));
//        quickSort(nums, 0, nums.length-1);
//        IntStream.range(0, nums.length).forEach(i -> System.out.println(nums[i]));
//        int[] sums = {7,8,8,10,4};
//        int[] sums = {3,7,2,3};
//		int sum = sumSubseqWidths(sums);
//        System.out.println(sum);
	}
	
	private static void quickSort2(int[] nums, int start, int end) {
		if(start >= end)
			return;
		if(start + 1 == end && nums[start] > nums[end]) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			return;
		}
		
		int low = start;
		int high = start+1;
		int pivot = end;
		while(high < pivot) {
			if(nums[high] <= nums[pivot]) {
				if(nums[low] > nums[pivot]) {
					int temp = nums[low];
					nums[low] = nums[high];
					nums[high] = temp;
					high++;
				}else {
					int temp = nums[low+1];
					nums[low+1] = nums[high];
					nums[high] = temp;
					low++;
					high++;
				}
			}else {
				high++;
			}
		}
		int swapPos = low;
		if(nums[low] <= nums[pivot])
			swapPos++;
//		System.out.println("swapPos: " + swapPos);
//		System.out.println("array: " + Arrays.toString(nums));
		int temp = nums[swapPos];
		nums[swapPos] = nums[pivot];
		nums[pivot] = temp;
		
		quickSort2(nums, start, swapPos -1 );
    	quickSort2(nums, swapPos+1, end);
	}
	
	 private static void quickSort(int[] nums, int head, int tail) {
	    	if(head >= tail)
	    		return;
	    	if(head + 1 == tail && nums[head] > nums[tail]) {
	    		int temp = nums[head];
	    		nums[head] = nums[tail];
	    		nums[tail] = temp;
	    		return;
	    	}
	    	int pivot = head;
	    	int start = head+1;
	    	int end = tail;
//	    	boolean swapped = false;
	    	while(start<end) {
	    		if(nums[start] > nums[pivot] && nums[end] < nums[pivot]) {
	    			int temp = nums[start];
	        		nums[start] = nums[end];
	        		nums[end] = temp;
	        		start++;
	        		end--;
//	        		swapped = true;
	    		}else if(nums[start] > nums[pivot])
	    			end--;
	    		else if(nums[end] < nums[pivot])
	    			start++;
	    		else {
	    			start++;
	    			end--;
	    		}
	    	}
	    	
	    	int swapPos = pivot;
	    	if(start == end) {
	    		if(nums[start] <= nums[pivot])
	    			swapPos = end;
	    		else if(nums[end-1] <= nums[pivot])
	    			swapPos = end-1;
	    	}
	    	if(start > end)
	    		swapPos = end;
	    	int temp = nums[swapPos];
	    	nums[swapPos] = nums[pivot];
	    	nums[pivot] = temp;
			
	    	quickSort(nums, head, swapPos-1);
	    	quickSort(nums, swapPos+1, tail);
	    }
	 
    public static int sumSubseqWidths(int[] nums) {
       
    	//sort: using quick sort    	
        List<Integer> sorted = IntStream.of(nums).sorted().boxed().collect(Collectors.toList());
        int start = 0;
        int end = sorted.size()-1;
        Map<Integer, Integer> dp = new HashMap<>();
        int MOD = 1_000_000_007;
        return findSubWidths(sorted, start, end, dp)%MOD;
    }
    
    private static int findSubWidths(List<Integer> sorted, int start, int end, Map<Integer, Integer> dp) {
    	if(end - start < 1) {
    		return 0;
    	}    	
    	int gap = end - start - 1;
    	int combinations = 0;
    	for(int i = gap; i >=0; i--) {
    		int fac = factorial(dp, gap)/factorial(dp, i)/factorial(dp, gap-i);    	
    		combinations += fac;
    	}
    	int numSub = (int) Math.pow(2, gap);
    	System.out.println("combination: " + combinations + "numSub: " + numSub);
    	int currWidthSum =(sorted.get(end) - sorted.get(start)) * numSub ;
    	return currWidthSum + findSubWidths(sorted, start+1, end, dp) + findSubWidths(sorted, start, end-1, dp);
    }
    
    private static int factorial(Map<Integer, Integer> dp, int number){
        if(number <= 0)
            return 1;
        if(number == 1)
            return 1;
        if(dp.containsKey(number))
            return dp.get(number);
        
        int result = number * factorial(dp, number-1);
        dp.put(number, result);
        return result;
    }
    
   
}
