package com.chrystian.amazon;

import java.util.*;

public class WordBreakII {
//https://leetcode.com/problems/word-break-ii/
    
    public static void main(String[] args){
        String s = "catsanddog";
//        List<String> wordDict = Arrays.asList("cat","sand","dog");
        List<String> wordDict = Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Map<String, Map> dictTree = new HashMap<>();
        breakIt(dictTree, s, wordDict);
        parseDict(dictTree, "", result);
        return result;
    }

    public static void breakIt(Map<String, Map> dictTree, String s, List<String> wordDict){
        for (String w : wordDict){
            int vocabLength = w.length();
            if(s.length() >= vocabLength && s.substring(0, vocabLength).equals(w)){
                Map<String, Map> subTree = new HashMap();
                dictTree.put(w, subTree);

                String remaining = s.substring(vocabLength);
                breakIt(subTree, remaining, wordDict);
            }
        }

    }

    public static void parseDict(Map<String, Map> dict, String cumulation, List<String> result){
        if (dict.isEmpty()){
            result.add(cumulation);
            return;
        }
        dict.entrySet().stream().forEach(e -> {
            Map<String, Map> value = e.getValue();
            parseDict(value, cumulation + "-" + e.getKey(), result);
        });
    }


}
