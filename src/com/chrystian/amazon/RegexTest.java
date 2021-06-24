package com.chrystian.amazon;

import java.util.Stack;

public class RegexTest {

    public static void main(String[] args) {
        String s = "mississppi";
        String p = "mis*is*p*.";
        System.out.println("Is " + s + " matched with " + p + ":");
        System.out.println(isMatch(s, p));
    }

    //https://leetcode.com/problems/regular-expression-matching/
    /*
    Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.​​​​
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).
    * */

    public static boolean isMatch(String s, String p) {
        Stack<Character> stackS = new Stack();
        Stack<Character> stackP = new Stack();
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();

        for(char c : sArray){
            stackS.push(c);
        }

        for (char c : pArray){
            stackP.push(c);
        }
        try {
            while (!stackP.empty()) {
                if (stackP.peek() == '*') {
                    stackP.pop();
                    while ( !stackS.empty() && isMatchSingle(stackS.peek(), stackP.peek()) ) {
                        stackS.pop();
                    }
                    stackP.pop();
                } else if (!isMatchSingle(stackS.peek(), stackP.peek())) {
                    return false;
                } else {
                    stackS.pop();
                    stackP.pop();
                }

            }
            return stackS.empty() && stackP.empty();
        }catch (Exception e){
            return false;
        }
    }

    public static boolean isMatchSingle(char s, char p){
        if (p == '.')
            return true;
        return s == p;
    }
}
