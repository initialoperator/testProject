package com.chrystian.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MaxArea{

    public static void main(String[] args){
        MaxArea sol = new MaxArea();
        int[] array = {1,8,6,2,5,4,8,3,7};
        int result = sol.maxArea(array);
        System.out.println(result);
    }

    public int maxArea(int[] height) {
        int length = height.length;
        int max = 0;
        int mid = length/2;
        int front = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        for(int i = 1; i < mid && i < length - mid; i++){
            int hf = height[mid - i];
            int hr = height[mid + i];
            if(hf >= front){
                height[mid - i + 1] = 0;
            }
            if(hr >= end){
                height[mid + i - 1] = 0;
            }
            front = hf;
            end = hr;
        }
        int non0s = (int)IntStream.of(height).filter(i -> i > 0).count();
        List<Integer[]> filtereds = new ArrayList<>();

        IntStream.range(0, length).forEach(i ->{
            filtereds.add(new Integer[]{i, height[i]});
        });

        for(int i = 0; i < non0s; i++){
            int dp = 0;
            for(int k = non0s - 1; k > i; k--){
                int hi = Math.min(filtereds.get(i)[0], filtereds.get(k)[0]);
                if(hi < dp)
                    continue;
                dp = hi;
                int width = filtereds.get(k)[1] - filtereds.get(i)[1];
                int area = hi *  width;
                max = Math.max(max, area);
            }
        }
        return max;
    }
}