package com.chrystian.concurrent;

public class TestRWLock {

	public static void main(String[] args) {

		RWLockObject rwo = new RWLockObject();
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				rwo.do1();				
			}			
		};
		
		Runnable r2 = () -> rwo.do1();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}

}
