package com.chrystian.interviews;

import java.util.*;

public class LongestWordChain {
    // https://leetcode.com/problems/longest-string-chain/

    public static void main(String[] args) {
        LongestWordChain sol = new LongestWordChain();
        String[] words = {"a","b","ba","bca","bda","bdca"};
        // words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        // words = new String[]{};
        words = new String[]{"a","ab","ac","bd","abc","abd","abdd"};
        int result = sol.longestStrChain(words);
        System.out.println(result);
        result = sol.longestStrChain2(words);
        System.out.println(result);

        boolean isNext = sol.isNext("a", "ac");
        System.out.println(isNext);
    }

    /*
Runtime: 21 ms, faster than 92.06% of Java online submissions for Longest String Chain.
Memory Usage: 38.8 MB, less than 87.66% of Java online submissions for Longest String Chain.    
    */
    public int longestStrChain2(String[] words) {
        if(words.length == 0)
            return 0;
        int shortest = words[0].length();
        int longest = 1;
        Map<Integer, List<String>> lengthMap = new HashMap<>();
        for(String word:words){
            int length = word.length();
            if(length < shortest)
                shortest = length;
            if(length > longest)
                longest = length;
            if(lengthMap.containsKey(length)){
                lengthMap.get(length).add(word);
            }else{
                List<String> list = new ArrayList<>();
                list.add(word);
                lengthMap.put(length, list);
            }
        }
        if(shortest == longest)
            return 1;
        Map<String, Integer> dp = new HashMap<>();
        List<String> longests = lengthMap.get(longest);
        longests.stream().forEach(s -> dp.put(s, 1));

        for(int i = longest-1; i >= shortest; i--){
            List<String> currs = lengthMap.get(i);
            List<String> prevs = lengthMap.get(i+1);
            for(String curr : currs){
                int length = 0;
                for(String prev : prevs){
                    if(isNext(curr, prev)){
                        length = Math.max(length,dp.get(prev));
                    }                       
                }
                dp.put(curr, 1+length);
            }
        }
        int max = dp.values().stream().sorted(Comparator.reverseOrder()).findFirst().get();
        return max;
    }

    private boolean isNext(String shorter, String longer){
        if(shorter.length() >= longer.length())
            return false;
        
        int s =0; int l = 0;
        while(s < shorter.length() && l < longer.length() && l - s >= 0 && l - s < 2){
            if(shorter.charAt(s) == longer.charAt(l)){
                s++;
                l++;
                // System.out.println("mactched");
            }else{
                l++;
            }                
        }
        // System.out.println("s at last: " + s);
        if(s == shorter.length())
            return true;
        else
            return false;
    }



    /*
Runtime: 34 ms, faster than 52.96% of Java online submissions for Longest String Chain.
Memory Usage: 39.3 MB, less than 30.01% of Java online submissions for Longest String Chain.    
    */
    public int longestStrChain(String[] words) {//using deleting characters + dp
        if(words.length == 0)
            return 0;
        Set<String> elements = new HashSet<>();
        for(String word:words){
            elements.add(word);
        }
        Map<String, Integer> lengths = new HashMap<>();
        for(String word:words){
            findLength(elements, lengths, word);
        }
        
        int max = lengths.values().stream().sorted(Comparator.reverseOrder()).findFirst().get();
        return max;
    }

    private int findLength(Set<String> elements, Map<String, Integer> lengths, String curr){
        if(!elements.contains(curr)){
            return 0;
        }else{
            if(lengths.containsKey(curr))
                return lengths.get(curr);
            else{
                int max = 0;
                for(int i = 0; i < curr.length(); i++){
                    StringBuilder sb = new StringBuilder(curr);
                    sb.deleteCharAt(i);
                    int sublength = findLength(elements, lengths, sb.toString());
                    if(sublength > max)
                        max = sublength;
                }
                lengths.put(curr, 1+max);
                return 1+max;

            }
        }
    }
}
