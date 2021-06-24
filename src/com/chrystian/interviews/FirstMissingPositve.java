package com.chrystian.interviews;

import java.util.Arrays;

public class FirstMissingPositve {

	public static void main(String[] args) {
		FirstMissingPositve sol = new FirstMissingPositve();
		int[] array = {3, 4, -1, 1};
		int result = sol.firstMissingPositive(array);
		System.out.println("result: " + result);
	}
	public int firstMissingPositive(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num < 0)
                nums[i] = 0;      
            if(num > 0){
                max = Math.max(max, num);
                min = Math.min(min, num);
            }                
        }
        if(min > 1)
            return 1;
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println(Arrays.toString(nums));
        
        for(int i = 0; i < nums.length; i++){
            int num = Math.abs(nums[i]);
            if(num == 0)
                continue;
            if(num > nums.length)//original bug: missing this condition check. This will result in crash for huge gap
            	continue;
            int position = num - 1;
            if(nums[position] == 0)
                nums[position] = (-1)*num;//original bug: nums[position] = (-1) * position
            else if(nums[position] > 0)
                nums[position] = (-1) * nums[position];
                            
        }
        System.out.println(Arrays.toString(nums));
        
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num >= 0)
                return i+1;                            
        }
        return max+1;
    }
}
