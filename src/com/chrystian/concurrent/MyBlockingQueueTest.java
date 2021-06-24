package com.chrystian.concurrent;

import java.nio.charset.Charset;
import java.text.Format;
import java.util.Random;

public class MyBlockingQueueTest {

    public static void main(String[] args){
        MyBlockingQueue queue = new MyBlockingQueue();

        Runnable producer = () -> {
            byte[] array = new byte[7];
            new Random().nextBytes(array);
            String randomString = new String(array, Charset.forName("UTF-8")) + "-" + Thread.currentThread().getName();
            queue.put(randomString);
            System.out.println("Putting in: " + randomString);
        };
        Runnable consumer = () -> {
            String item = queue.remove();
            System.out.println("Taking out: " + item);
        };


        while(true){
            new Thread(producer).start();
            new Thread(consumer).start();
//            new Thread(consumer).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
