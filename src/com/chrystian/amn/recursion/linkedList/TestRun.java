package com.chrystian.amn.recursion.linkedList;

public class TestRun {
    public static void main(String[] args) {
        TestRun tr = new TestRun();
        int[] nums1 = {};
        int[] nums2 = {2,3};
        double result = tr.findMedianSortedArrays(nums1,nums2);
        System.out.println("result is: "+ result);
    }

    /*
    https://leetcode.com/problems/median-of-two-sorted-arrays/description/
    * */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //the first part is to merge them into one array
        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1+length2;
        int medianPos = total/2;
        int pos1 = 0;
        int pos2 = 0;
        int posm = 0;
        int[] merged = new int[total];
        while (pos1 < length1 || pos2 < length2){
            if(pos1 >= length1){
                merged[posm] = nums2[pos2];
                pos2++;
                posm++;
            }else if(pos2 >= length2){
                merged[posm] = nums1[pos1];
                pos1++;
                posm++;
            }else{
                int head1 = nums1[pos1];
                int head2 = nums2[pos2];
                if(head1 <= head2){
                    merged[posm] = nums1[pos1];
                    pos1++;
                    posm++;
                }else{
                    merged[posm] = nums2[pos2];
                    pos2++;
                    posm++;
                }
            }
        }
        if(merged.length == 1)
            return merged[0];
        if(total%2==0){
            return (merged[medianPos-1]+merged[medianPos]+0.0)/2;
        }else
            return merged[medianPos];
    }



    public double findMedianSortedArrays_del(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1+length2;
        int medianPos = total/2;
        if(medianPos == 0){
            if(length1>0)
                return nums1[0];
            if(length2>0)
                return nums2[0];
        }else if(total == 2){
            if(length1 == 0)
                return (nums2[0] + nums2[1] + 0.0)/2;
            else if(length2 == 0)
                return (nums1[0] + nums1[1] + 0.0)/2;
            else
                return (nums1[0] + nums2[0] + 0.0)/2;
        }
        int pos1 = 0;
        int pos2 = 0;
        int posm = 0;
        int current = 0;
        int next = 0;
        while ((pos1 < length1 || pos2 < length2) && posm <= medianPos){
            if(pos1 >= length1){
                current = nums2[pos2];
                pos2++;
                posm++;
                next = nums2[pos2];
            }else if(pos2 >= length2){
                current = nums1[pos1];
                pos1++;
                posm++;
                next = nums1[pos1];
            }else{
                int head1 = nums1[pos1];
                int head2 = nums2[pos2];
                if(head1 <= head2){
                    current = head1;
                    pos1++;
                    posm++;
                }else{
                    current = head2;
                    pos2++;
                    posm++;
                }
                if(pos1 >= length1)
                    next = nums2[pos2];
                else if(pos2 >= length2){
                    next = nums1[pos1];
                }else{
//                    next = Math.min(nums1[pos1], nums2[pos2]);
                    next = head1 <= head2?head1:head2;
                }

            }
        }
        if(total%2 != 0){
            return current;
        }else{
            return (current + next + 0.0)/2.0;
        }
    }

}
