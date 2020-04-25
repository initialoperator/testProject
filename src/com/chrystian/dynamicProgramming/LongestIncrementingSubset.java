package com.chrystian.dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LongestIncrementingSubset {
    public static void main(String[] args){
        int[] input = {1, 7, 6, 2, 3};
        List<Integer> result = find(input);
        System.out.println(result);
    }

    private static List<Integer> find(int[] input){
        List<Integer> result = new ArrayList<>();
        for(int start = 0; start < input.length; start++){
            Stack<Integer> resultTemp = new Stack<>();
            int end = start;
            while(end < input.length){
                if(resultTemp.size() == 0 || resultTemp.peek().intValue() < input[end])
                    resultTemp.push(input[end]);
                end++;
            }

            if(resultTemp.size() > result.size()){
                result = new ArrayList<>();
                resultTemp.stream()
//                        .sorted(Collections.reverseOrder())
                        .forEach(result::add);
            }
        }
        return result;
    }
}
