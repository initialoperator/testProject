package com.chrystian.amazon;

import com.chrystian.amn.recursion.stack.MyStack;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class RandomTest {

    static{
        System.out.println("block 1");
    }

    {
        System.out.println("block 2");
    }
    public static void main(String[] args){


        Double d = 1.0;
        double e = 1.0;
        d++;
        System.out.println((Double)e instanceof Double);
    }


    interface MyInterface{
//        public void says();
        default public void display(){
            System.out.println("");
        }
    }
    abstract class MyClass implements MyInterface{
        abstract public void display();
    }
}
