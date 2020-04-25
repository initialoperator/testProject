package com.chrystian.amn.recursion;

public class PickMoreCoinsGame {
    public static void main(String[] args){
        int[] array = {18, 20, 15, 30, 10, 14};
        int collect = firstPick(0, array.length-1, array);
        System.out.println(collect);
    }
    private static int firstPick(int startIndex, int endIndex, int[] array){
        if(startIndex == endIndex){
            return array[startIndex];
        }else{
            int valueForPickStart = array[startIndex] + secondPick(startIndex+1, endIndex, array);
            int valueForPickEnd = array[startIndex] + secondPick(startIndex, endIndex-1, array);
            return Math.max(valueForPickStart, valueForPickEnd);
        }
    }
    private static int secondPick(int startIndex, int endIndex, int[] array){
        if(startIndex == endIndex){
            return 0;
        }else{
            int valueForPickStart = firstPick(startIndex+1, endIndex, array);
            int valueForPickend = firstPick(startIndex, endIndex-1, array);
            return Math.max(valueForPickStart, valueForPickend);
        }
    }

}
