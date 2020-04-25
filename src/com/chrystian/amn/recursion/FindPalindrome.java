package com.chrystian.amn.recursion;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.of;

public class FindPalindrome {

    public static void main(String[] args){
        int i = 12;
        String s = "12";
        try{
            Integer si = Integer.parseInt(s);
            System.out.println(i == si);
        }catch (NumberFormatException e){

        }
    }

    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {

        //part1: filter out apps the single of which can bust out the memory
        // (this part can be move to part 2 but the filterList would be better to produce first)
        List<List<Integer>> filteredFore = foregroundAppList.stream().filter(app -> {
            if(app.get(1) < deviceCapacity)
                return true;
            else
                return false;
        }).collect(Collectors.toList());

        List<List<Integer>> filteredBack = backgroundAppList.stream().filter(app -> {
            if(app.get(1) < deviceCapacity)
                return true;
            else
                return false;
        }).collect(Collectors.toList());

        //part2: determine the maximum possible memory to be reached.
        //using a set to first store all the possible memory consumption and later find the max one.
        Set<Integer> memories = new HashSet<>();
        Iterator<List<Integer>> foreIt = filteredFore.iterator();
        while(foreIt.hasNext()){
            List<Integer> foreApp = foreIt.next();
            Iterator<List<Integer>> backIt = filteredBack.iterator();
            while ((backIt.hasNext())){
                List<Integer> backApp = backIt.next();
                if(foreApp.get(1)+backApp.get(1) <= deviceCapacity)
                    memories.add(foreApp.get(1)+backApp.get(1));
            }
        }

        //Part3 determining the pairs
        //if memory set is empty, that means no fore-background app pair is valid, return an empty list
        //else, find the max memory consumption and determine the pairs that produce a such consumtion
        if(memories.size() == 0)
            return new ArrayList<List<Integer>>();
        else{
            Integer maxConsumption = memories.stream().sorted(Comparator.reverseOrder()).findFirst().get();
            List<List<Integer>> result = new ArrayList<>();
            filteredFore.stream().forEach(foreApp -> {
                filteredBack.stream().forEach(backApp -> {
                    if(foreApp.get(1) + backApp.get(1) == maxConsumption){
                        List<Integer> entry = new ArrayList<>();
                        entry.add(foreApp.get(0));
                        entry.add(backApp.get(0));
                        result.add(entry);
                    }
                });
            });
            return result;
        }
    }

    public List<String> orderedJunctionBoxes(int numberOfBoxes,
                                             List<String> boxList)
    {
        //going through the list extract all the old versions
        //a filter is applied by keeping all the version text that cannot be parsed as an integer
        //a sorting algorith is applied to first sort based on the version part of the string, or else sort based on the identifier as the first part
        List<String> oldVersions = boxList.stream().filter(b -> {
            String[] split = b.split(" ");
            for(int i = 1; i < split.length; i++){
                String token = split[i];
                try{
                    Integer.parseInt(token);
                } catch (NumberFormatException ex)
                {
                    return true;
                }
            }
            return false;
        }).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int space1 = o1.indexOf(" ");
                int space2 = o2.indexOf(" ");
                String v1 = o1.substring(space1);
                String v2 = o2.substring(space2);
                if(v1.compareTo(v2) == 0){
                    String[] tokens1 = o1.split(" ");
                    String[] tokens2 = o2.split(" ");
                    return tokens1[0].compareTo(tokens2[0]);
                }else
                    return v1.compareTo(v2);
            }
        }).collect(Collectors.toList());

        //going through the list and extract all the new versions
        //a filter is applied by keeping all the version text that can be parsed as an integer
        List<String> newVersions = boxList.stream().filter(b -> {
            String[] split = b.split(" ");
            for(int i = 1; i < split.length; i++){
                String token = split[i];
                try{
                    Integer.parseInt(token);
                } catch (NumberFormatException ex)
                {
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList());

        //after all the computation, merge back 2 list in the correct order
        List<String> result = new ArrayList<>();
        result.addAll(oldVersions);
        result.addAll(newVersions);
        return result;
    }


    public static int generalizedGCD(int num, int[] arr)
    {
        if(num == 0)
            return 1;
        else{
            Set<Integer> commons = new HashSet<>();
            int smallest = IntStream.of(arr).sorted().findFirst().getAsInt();
            IntStream.range(1, smallest+1).forEach(d -> {
                boolean isCommon = true;
                for(int i = 0; i < arr.length; i++){
                    if(arr[i] % d != 0)
                        isCommon = false;
                }
                if(isCommon)
                    commons.add(d);
            });
            if(commons.size() == 0)
                return 1;
            else{
                return commons.stream().sorted(Comparator.reverseOrder()).findFirst().get();
            }
        }
    }

    public List<Integer> cellCompete(int[] states, int days)
    {
        int[] today = states;
        // WRITE YOUR CODE HERE
        IntStream.range(0, days).forEach(d -> {
            int[] nextDay = new int[states.length];
            IntStream.range(0, states.length).forEach(i -> {
                int nextStatus = this.determineNextStatus(i, states);
                nextDay[i] = nextStatus;
            });
            IntStream.range(0, states.length).forEach(i -> {
                today[i] = nextDay[i];
            });
        });
        List<Integer> result = new ArrayList<>();
        IntStream.range(0, states.length).forEach(i -> {
            result.add(today[i]);
        });
        return result;
    }

    private int determineNextStatus(int index, int[] array){
        int left = 0;
        if(index <= 0 )
            left = 0;
        else
            left = array[index - 1];

        int right = 0;
        if(index >= array.length - 1)
            right = 0;
        else
            right = array[index+1];
        return left == right? 0 : 1;
    }

    private static String findPalindromeSubstring(String input){

        if(input.length() == 1){
            return input;
        }
        Stack<Character> cStack = new Stack<>();
        Stack<Integer> iStack = new Stack<>();


        char[] array = input.toCharArray();
        List<Pair<Integer, Integer>> panPairs = IntStream.range(0, input.length()).mapToObj(i -> {
            return findMaxPanlidromeWidth(i, array);
        }).collect(Collectors.toList());

        List<Pair<Integer, Integer>> indexPairs= panPairs.stream().sorted(new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                int diff1 = Math.abs(o1.getKey() - o2.getValue());
                int diff2 = Math.abs(o2.getKey() - o2.getValue());
                return diff1 > diff1 ? -1 : 1;
            }
        }).collect(Collectors.toList());
        Optional<Pair<Integer, Integer>> longestOptional = indexPairs.stream().findFirst();

        Pair<Integer, Integer> longest = longestOptional.get();
        StringBuilder sb = new StringBuilder();
        IntStream.range(longest.getKey(), longest.getValue()+1).mapToObj(i -> array[i]).forEach(sb::append);

        return sb.toString();
    }

    private static Pair<Integer, Integer> findMaxPanlidromeWidth(int pivot, char[] array){
        int localMax = 0;
        for(int i = 1; pivot  + i < array.length && pivot - i >= 0; i++){
            if(array[pivot - i] == array[pivot + i])
                localMax = i;
            else
                break;
        }
        return new Pair<>(pivot-localMax, pivot+localMax);
    }


}
