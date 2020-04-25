package com.chrystian.amn.recursion.stack;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueuedStack<T> {
    private Queue<T> mainQ = new LinkedBlockingQueue<>();
    private Queue<T> spareQ;
    private int length = 0;

    public void push(T element){
        mainQ.add(element);
        length++;
    }

    public T pop(){
        spareQ = new LinkedBlockingQueue<>();
        int count = length;
        while (count > 1){
            spareQ.add(mainQ.remove());
            count--;
        }
        T peak = mainQ.remove();
        mainQ = spareQ;
        length--;
        return peak;
    }

}
