package com.chrystian.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

class StandardLock implements java.util.concurrent.locks.Lock {

    public static class LockAlreadyHeldException extends RuntimeException {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5310694780702526532L;}

    private final java.util.concurrent.locks.ReentrantLock mainLock;

    private void checkNotAlreadyHeld() {
        if (mainLock.getHoldCount()!=0) {
            throw new LockAlreadyHeldException();
        }
    }

    public StandardLock() {
        mainLock=new java.util.concurrent.locks.ReentrantLock();
    }

    public StandardLock(boolean fair) {
        mainLock=new java.util.concurrent.locks.ReentrantLock(fair);
    }

    @Override
    public void lock() {
        checkNotAlreadyHeld();
        mainLock.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        checkNotAlreadyHeld();
        mainLock.lockInterruptibly();
    }

    @Override
    public boolean tryLock() {
        checkNotAlreadyHeld();
        return mainLock.tryLock();
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        checkNotAlreadyHeld();
        return mainLock.tryLock(time, unit);
    }

    @Override
    public void unlock() {
        mainLock.unlock();
    }

	@Override
	public Condition newCondition() {
        return mainLock.newCondition();
	}

}