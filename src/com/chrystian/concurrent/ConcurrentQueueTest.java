package com.chrystian.concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


public class ConcurrentQueueTest {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList<>();//will be replaced with your own blocking queue
		
		final Runnable producer = () -> {
			while(true) {
				queue.add(new Random().toString());
			}
		};
		
		final Runnable consumer = () -> {
			while(true) {
					String s = queue.poll();
//					if (s != null)
					System.out.println(s);
			}
		};
		
		new Thread(producer).start();
		new Thread(consumer).start();		

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
