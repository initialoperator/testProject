package com.chrystian.concurrent;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class RWLockObject {

	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	private Integer i1;
	private Integer i2;
	
	public RWLockObject() {
		i1 = new Integer(0);
		i2 = new Integer(0);
	}
	
	public void do1() {
		IntStream.range(0, 5).forEach(i -> {
			try {
				Thread.sleep(i*80L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thread: " + Thread.currentThread().getName() + " " + "i1: " + i1);
			System.out.println("Thread: " + Thread.currentThread().getName() + " " + "i2: " + i2);
			lock.readLock().lock();
			try {
				i1++;
				do2();
				i--;
			}finally {
				lock.readLock().unlock();
			}
			
		});
	}
	
	public void do2() {
		lock.readLock().lock();
//		checkNotAlreadyHeld();
		try {
//			i1++;
			i2++;
		}finally {
			lock.readLock().unlock();
		}
	}
}
