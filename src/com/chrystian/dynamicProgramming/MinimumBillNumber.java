package com.chrystian.dynamicProgramming;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class MinimumBillNumber {

    /*
    * given a certain variety of bills, find the minimum number of bills needed to form a certain amount of money
    * */
    public static void main(String[] args){
        int result1 = formedByVariety1(15);
        System.out.println(result1);
    }
    private static Set<Integer> vars1 = new HashSet();
    static{
        vars1.add(1);
        vars1.add(5);
        vars1.add(11);
    }
    //when the variety is $1's, $5's, $11's
    private static int formedByVariety1(int total){
        if(total == 0)
            return 0;
        int cost =  Integer.MAX_VALUE;
        Iterator<Integer> varsIterator= vars1.iterator();
        while(varsIterator.hasNext()){
            int var = varsIterator.next();
            if(total - var >= 0)
                cost = Math.min(cost, formedByVariety1(total-var) + 1);
        }
        return cost;
    }
}
