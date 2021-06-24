package com.chrystian.concurrent;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;


public class NormalClass {

    int sum = 0;

    final AtomicInteger count = new AtomicInteger(0);
    
    volatile Integer count2 = 0;
    
    public void getCount() {
        
        count.incrementAndGet();       
//        System.out.println(count.incrementAndGet());
    }
    
    public void reentrantCount() {
    	Lock lock = new ReentrantLock();
    	lock.tryLock();
    	count2++;
    	System.out.println(count2);
    	lock.unlock();
    	System.gc();
    }
    
    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void calculate(int input) {
        setSum(getSum() + input);
    }

    public synchronized void calculate2() {
        setSum(getSum() + 1);
    }

    public void blockingMethod() {
        synchronized (this) {
            try {
//            while(true)
                System.out.println(Thread.currentThread().getName());
                calculate(2);
                Thread.sleep(1000);
            } catch (Exception e){

            }
        }
    }

    public void nonBlockingMethod() {
        System.out.println("print print");
        System.out.println(this.getSum());
        calculate(100);
        System.out.println(this.getSum());
    }

//    @Test
//    public void multithreadTest() throws Exception {
//        ExecutorService service = Executors.newFixedThreadPool(3);
//        NormalClass c = new NormalClass();
//        IntStream.range(0, 1000).forEach(count -> service.submit(c::calculate2));
//
//        service.awaitTermination(1000, TimeUnit.MILLISECONDS);
//        assertEquals(1000, c.getSum());
//    }
//
//    @Test
//    public void testBlocking() {
//        NormalClass c = new NormalClass();
//        Thread t1 = new Thread(() -> {
//            while(true)
//                c.calculate2();
//        });
//        Thread t2 = new Thread(c::nonBlockingMethod);
//        t1.start();
//        t2.start();
//    }

    public static void main(String[] args) throws Exception {
        NormalClass c = new NormalClass();
        Thread t1 = new Thread(() -> {
            IntStream.range(0,10).forEach(count -> c.blockingMethod());
        });
        System.out.println(t1.getName());
        Thread t2 = new Thread(c::blockingMethod);
        System.out.println(t2.getName());
//        t1.start();
//        Thread.sleep(50);
//        t2.start();
        
        Thread t3 = new Thread(() -> {
        	IntStream.range(0,10).forEach(count -> c.reentrantCount());
        });
        Thread t4 = new Thread(() -> {
        	IntStream.range(0,10).forEach(count -> c.reentrantCount());
        });
        Thread t5 = new Thread(() -> {
        	IntStream.range(0,10).forEach(count -> c.reentrantCount());
        });
        t3.start();
        t4.start();
        t5.start();
    }
}
