package com.chrystian.trycatchexception;

public class FinallyTestRun {

    public static void main(String[] args) {

        String result = returnTwice();
        System.out.println(result);
    }

    public static String returnTwice(){
        try{
            return "try";
        }catch (Exception io){

        }
        return "finally";
    }
}
