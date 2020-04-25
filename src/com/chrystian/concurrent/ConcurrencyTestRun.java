package com.chrystian.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrencyTestRun {
    public static void main(String[] args) {
        for(int i = 0; i < 3; i++){
            Thread t = new Thread(new Task(i));
            t.start();
            try{
                t.join();
            }catch (InterruptedException e){

            }
        }
    }
}
