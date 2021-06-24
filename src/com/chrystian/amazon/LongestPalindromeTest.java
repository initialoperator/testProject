package com.chrystian.amazon;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.List;
import java.util.stream.IntStream;

public class LongestPalindromeTest {
//https://leetcode.com/problems/longest-palindromic-substring/
    public static void main(String[] args){
        String s = "firsttsrifpaaaabaaaap";
        String panFromS = longestPalindrome(s);

        System.out.println(panFromS);
    }

    public static String longestPalindrome(String s) {
        int[] boundaries = null;
        char[] sequences = s.toCharArray();
        for(int i = 0; i < sequences.length ;i++){
            int[] positions = positions(sequences, i);
            if(boundaries == null)
                boundaries = positions;
            else{
                int distanceB = boundaries[1] - boundaries[0];
                int distanceP = positions[1] - positions[0];
                if (distanceP > distanceB)
                    boundaries = positions;
            }
        }
        return s.substring(boundaries[0], boundaries[1]+1);
    }

    private static int[] positions(char[]chars, int center){
        int[] result = new int[2];
        int start = center;
        int end = center;

        while(start >= 0 && end < chars.length){
            if(chars[start] == chars[end]){
                result[0] = start;
                result[1] = end;
                 start--;
                 end++;
            }else{
                break;
            }
        }

        int[] resultEven = new int[2];
        start = center;
        end = center + 1;
        while(start >= 0 && end < chars.length){
            if(chars[start] == chars[end]){
                resultEven[0] = start;
                resultEven[1] = end;
                start--;
                end++;
            }else{
                break;
            }
        }

        return result[1] - result[0] > resultEven[1] - resultEven[0] ? result : resultEven;
    }
}
