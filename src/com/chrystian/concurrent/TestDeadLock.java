package com.chrystian.concurrent;

public class TestDeadLock {

	public static void main(String[] args) {
	    final  String resource1 = "santanu";
	    final String resource2 = "sahoo";
	     System.out.println(Integer.toHexString(resource1.hashCode())    );
	     System.out.println(Integer.toHexString(resource2.hashCode()) );

	    Thread t1 = new Thread(){

	        public void run()
	        {
	            synchronized (resource1) {
	                System.out.println(Thread.currentThread().getName() + ": locked resource 1");  
	                try {

	                    Thread.sleep(200);

	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                synchronized (resource2) {
	                     System.out.println(Thread.currentThread().getName() + ": locked resource 2");     
	                }               
	            }
	        }
	    };
	    Thread t2 = new Thread(){
	        public void run()
	        {
	            synchronized (resource2) {
	                try {
	                     System.out.println(Thread.currentThread().getName() + ": locked resource 2");  
	                    Thread.sleep(200);
	                } catch (InterruptedException e) {
	                                            e.printStackTrace();
	                }
	                synchronized (resource1) {
	                     System.out.println(Thread.currentThread().getName() + ": locked resource 1");  
	                }
	            }
	        }
	    };

	    t1.start();
	    t2.start();
	}
}
