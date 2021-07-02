package com.chrystian.interviews;

import java.util.HashSet;
import java.util.Set;

public class ResultTest2 {
    public static void main(String[] args) {
        ResultTest2 sol = new ResultTest2();
        String s = "aaabbb";
        int result = sol.firstUniqChar(s);
        System.out.println(result);
        
    }
    

    public int firstUniqChar(String s) {//a better solution is to use an int array of length 26 as a map to record the occurrences: only lower case -> limited number of possibilities -> can use array as a map
        char[] cs = s.toCharArray();
        Set<Character> dict = new HashSet<>();

        for(int i = s.length()-1; i >= 0; i--){
            if(dict.contains(cs[i])){        
                dict.remove(cs[i]);
                dict.add(Character.toUpperCase(cs[i]));
                cs[i] = 0;
            }else if(dict.contains(Character.toUpperCase(cs[i]))){
                cs[i] = 0;
            }else{
                dict.add(cs[i]);
            }
        }
        System.out.println("set: " + dict);
        for(int i = 0; i < s.length(); i++){
            if( cs[i] != 0 && dict.contains(cs[i]))   
                return i;
        }
        return -1;
    }
}
