package com.chrystian.amazon;

import java.util.stream.IntStream;

public class TrappingRainTest {
//https://leetcode.com/problems/trapping-rain-water/
    public int trap(int[] height) {
        int peak = 0;
        for (int h : height){
            if (h > peak)
                peak = h;
        }
        int total = 0;
        while (peak > 0){
            int[] convert = convert(height, peak);
            int sum = countMiddleZero(convert);
            total += sum;
            peak--;
        }
        return total;
    }

    private static int countMiddleZero(int[] vector){
        int sum = 0;
        boolean leak = true;
        int cumulation = 0;
        for(int num: vector){
            if (num == 1){
                leak = false;
                sum = sum + cumulation;
                cumulation = 0;
            }
            if (!leak && num == 0){
                cumulation++;
            }
        }

        return sum;
    }
    private static int[] convert(int[] nums, int threshhold){
        final int[] result = new int[nums.length];
        IntStream.range(0, nums.length).forEach(i -> {
            if (nums[i] >= threshhold)
                result[i] = 1;
            else
                result[i] = 0;
        });
        return result;
    }
}
