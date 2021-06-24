package com.chrystian.amazon;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveNumberTest {
//https://leetcode.com/problems/first-missing-positive/
/*
* key to solution: how search for a (missing) integer incrementally without needing to sort
* because sorting costs time.
* Solution, use hashset to do O(1) lookup
* */
    public static void main(String[] args){
        int[] nums = {1,7,8,4,9,5, 2, 11, 3, 12};
        int smallest = firstMissingPositive(nums);
        System.out.println(smallest);
    }

    public static int firstMissingPositive(int[] nums) {
        Set<Integer> existing = new HashSet<>();
        Integer currentSmallest = null;
        for(int num : nums){
            if(num <= 0)
                continue;
            existing.add(num);
            if(currentSmallest == null || num < currentSmallest.intValue())
                currentSmallest = num;
        }
        if (currentSmallest > 1)
            return 1;
        else {
            int find = currentSmallest;
            while (!existing.isEmpty()){
                if (existing.contains(find)){
                    existing.remove(find);
                    find++;
                }else
                    break;
            }
            return find;
        }
    }
}
