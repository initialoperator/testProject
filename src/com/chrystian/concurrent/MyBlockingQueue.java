package com.chrystian.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
    private Queue<String> queue = new LinkedList<>();
    Lock lock = new ReentrantLock();
    Condition notEmpty = lock.newCondition();

    public void put(String item){
        lock.lock();
        try{
            queue.add(item);
            notEmpty.signalAll();
            System.out.println("no longer empty!!");
        }finally {
            lock.unlock();
        }
    }

    public String remove(){
        lock.lock();
        String item = null;
        try{
            item = queue.remove();
            if(queue.isEmpty()){
                notEmpty.await();
                System.out.println("Queue is empty!!!");
            }
        }finally {
            lock.unlock();
            return item;
        }
    }


}
