package com.chrystian.trycatchexception;

import java.io.IOException;

public class TryWithResourceTestRun {

    public static void main(String[] args) {
        final ExceptionParent ep = new ExceptionParent();
        try(MyClosable mc = ep.calculate(3)){
            System.out.println("normal process");
        }catch (IOException e){
            System.out.println("Exceptional Process");
        }
    }
}
