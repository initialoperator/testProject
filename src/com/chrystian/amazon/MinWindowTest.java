package com.chrystian.amazon;

import java.util.*;
import java.util.stream.IntStream;

public class MinWindowTest {
//https://leetcode.com/problems/minimum-window-substring/

    public static void main(String[] args){
        System.out.println(minWindow("ADOBECODEBANDVWBVFDCR", "ABC"));
    }

    public static String minWindow(String s, String t) {

        List<Character> sList = new ArrayList<>();
        Set<Character> tSet = new HashSet<>();
        char[] split = s.toCharArray();
        for(char c: split){
            sList.add(new Character(c));
        }

        char[] tSplit = t.toCharArray();
        for(char c: tSplit){
            tSet.add(c);
        }
        Map<Integer, Integer> windows = new HashMap<>();

        findMatch(windows, sList, t, tSet, 0, 0);

        Integer result = windows.keySet().stream().filter(k -> windows.get(k) != null)
                .sorted((k1, k2) -> Integer.compare(windows.get(k1)-k1, windows.get(k2)-k2)).findFirst().orElse(null);

        if(result != null){
            return s.substring(result, windows.get(result));
        }
        return null;
    }

    public static void findMatch(Map<Integer, Integer> windows, List<Character> sList, String pattern, Set<Character> remaining, int startIndex, int currentIndex){
        if(remaining.isEmpty()){
            windows.put(startIndex, currentIndex);
            return;
        }

        if(currentIndex >= sList.size())
            return;

        if(remaining.contains(sList.get(currentIndex))){
            windows.put(new Integer(currentIndex), null);
            Set<Character> tSet = new HashSet<>();
            char[] tSplit = pattern.toCharArray();
            for(char c: tSplit){
                tSet.add(c);
            }
            tSet.remove(sList.get(currentIndex));
            findMatch(windows, sList, pattern, tSet, currentIndex, currentIndex+1);

            remaining.remove(sList.get(currentIndex));

        }

        findMatch(windows, sList, pattern, remaining, startIndex, currentIndex+1);

    }


}
