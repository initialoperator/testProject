package com.chrystian.concurrent;

public class TestSyncObejct {
	
	public static void main(String[] args) {
		SyncObject so = new SyncObject();
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				so.do1();				
			}			
		};
		
		Runnable r2 = () -> so.do1();
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
	}
}
