package com.chrystian.trycatchexception;

import java.io.IOException;

public class ExceptionParent {

    public void test() throws NullPointerException, IOException {
        System.out.println("test running");
        throw new IOException();
    }

    public MyClosable calculate(int i) throws NullPointerException, IOException {
        if(i % 2 == 0)
            return new MyClosable();
        else
            throw new IOException();
    }
}
