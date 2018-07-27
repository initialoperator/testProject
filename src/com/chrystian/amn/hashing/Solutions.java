package com.chrystian.amn.hashing;

import java.util.*;

public class Solutions {
/*
* Given an array having both positive an negative integers .
* Your task is to complete the function maxLen which returns the length of maximum subarray with 0 sum .
* The function takes two arguments an array A and n where n is the size of the array A .
 * */

    public static void main(String[] args) {

//        testcase1();

        String text = "Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favourte food.";
//        List<String> result = re

    }

    public List<String> reorderLines(int logFileSize, List<String> logLines){
        List<String> stringLines = new ArrayList<>();
        List<String> numLines = new ArrayList<>();
        Map<String, LinkedList<String>> map = new HashMap<>();
        for(String line : logLines){
            String[] tokens = line.split("\\s");
            try{
                int i = Integer.parseInt(tokens[1]);
            }catch (NumberFormatException e){
                int spacePos = line.indexOf(" ");
                String substring = line.substring(spacePos, line.length());
                LinkedList<String> list = map.get(substring);
                if(list == null){
                    LinkedList<String> l = new LinkedList<>();
                    l.add(line);
                    map.put(substring, l);
                }else{
                    boolean done = false;
                    for(int i = 0; i < list.size(); i++){
                        String element = list.get(i);
                        String[] currToken = element.split("\\s");
                        if(tokens[0].compareTo(currToken[0]) < 0){
                            list.add(i, line);
                            done = true;
                        }
                    }
                    if(!done)
                        list.addLast(line);
                }
                stringLines.add(line);
                continue;
            }
            numLines.add(line);
        }

        //sort
        List<String> sorted = new LinkedList<>();
        for(String line : stringLines){

        }
        return null;
    }

    List<String> retrieveMostFrequents(String text, List<String> excludes){
        Map<String, Integer> map = new HashMap<>();
        String [] tokens = text.split("\\s|\\'");
        for(String token : tokens){
            if(excludes.contains(token))
                break;
            Integer i = map.get(token);
            if(i == null)
                map.put(token, new Integer(1));
            else
                map.put(token, new Integer(i.intValue() + 1));
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it = set.iterator();
        int maxCount = 0;
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            int value = entry.getValue().intValue();
            maxCount = Math.max(maxCount, value);
        }
        List<String> maxwords = new ArrayList<>();
        it = set.iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            int value = entry.getValue().intValue();
            if(value == maxCount)
                maxwords.add(entry.getKey());
        }
        return maxwords;

    }
    private static  void testcase1(){
        Solutions s = new Solutions();
        int[] arr =  {3, 3, 4,-3, 9, -5, -8,8, -11, 4};
        int length = s.maxLen(arr, arr.length);
        System.out.println("Test cases1: "+length);
    }
    int maxLen(int arr[], int n) {

        int maxLength = 0;
        for(int i = 0; i < n; i++){
            if(maxLength < n-i)
                maxLength = kadaneForMaxLengthZero(arr, i, maxLength);
            else
                break;
        }
        return maxLength;
    }

    int kadaneForMaxLengthZero(int[] arr, int start, int maxLengthSoFar){
        if(arr.length - start < maxLengthSoFar)
            return maxLengthSoFar;
        int lengthSoFar = maxLengthSoFar;
        int sumSoFar = 0;
        for(int i = 0; i < arr.length - start; i++){
            sumSoFar += arr[start+i];
            if(sumSoFar == 0){
                lengthSoFar = Math.max(i+1, lengthSoFar);
            }
        }
        return lengthSoFar;
    }
}
