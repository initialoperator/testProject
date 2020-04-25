package com.chrystian.concurrent;

public class Task implements Runnable {
    private final int threadNum;
    public Task(int num){
        threadNum = num;
    }
    @Override
    public void run(){
        System.out.println("Thread " + threadNum + " is running..");
    }


}
