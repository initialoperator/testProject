package com.chrystian.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ConcurrencyTestRun {
    public static void main(String[] args) {
//        for(int i = 0; i < 3; i++){
//            Thread t = new Thread(new Task(i));            
//            t.start();
//            try{
//                t.join();
//            }catch (InterruptedException e){
//
//            }
//        }
        
        Thread t2 = new Thread(()->{
        	IntStream.range(0, 10).forEach(i -> {
        		System.out.println("printing " + i);
        		try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	});
        });
        
        t2.start();
        
        System.out.println("pass1");
        
        try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("pass2");
    }
}
