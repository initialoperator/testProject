package com.chrystian.concurrent;

import java.util.stream.IntStream;



public class SyncObject {

	private int i1;
	private Integer i2 ;
	private Integer i3;
	
	public SyncObject() {
		i2 = new Integer(0);
		i3 = new Integer(0);
	}
	
	public  void do1() {
		IntStream.range(0, 5).forEach(i -> {
			try {
				Thread.sleep(i*80L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i1++;
			synchronized(this){
				i2++;
				do2();
//				System.out.println("Thread: " + Thread.currentThread().getName() + " " + "i1: " + i1);
//				System.out.println("Thread: " + Thread.currentThread().getName() + " " + "i2: " + i2);
				System.out.println("Thread: " + Thread.currentThread().getName() + " " + "i3: " + i3);
			}
//			if(i1 == 5)
//				System.out.println("i1 has reached the value");
//			if(i2 == 5)
//				System.out.println("i2 has reached the value");
//			if(i3 == 5)
//				System.out.println("i3 has reached the value");
		});
	}
	
	public void do2() {
		synchronized(this) {
			i3++;
		}
	}
}
