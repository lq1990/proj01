package com.wendao.advanced;


/** 
 * 可重入锁，案例。
 * 锁可以延续使用
 * @author china
 *
 */
public class LockTest01_Reentrant {
	
	ReLock lock = new ReLock();
	
	public void a() throws InterruptedException {
		System.out.println("a begins");
		lock.lock();
		System.out.println("	lock count: "+lock.getHoldCount());
		
		doSth();
		lock.unlock();
		System.out.println("	lock count: "+lock.getHoldCount());
		System.out.println("a ends");
	}
	
	public void doSth() throws InterruptedException {
		System.out.println("doSth begins");
		lock.lock();
		System.out.println("	lock count: "+lock.getHoldCount());
		
		// ....
		lock.unlock();
		System.out.println("	lock count: "+lock.getHoldCount());
		System.out.println("doSth.ends");
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockTest01_Reentrant t = new LockTest01_Reentrant();
		t.a();
		t.doSth();
	}
	
}


// 不可重入锁
class ReLock {
	// 是否占用
	private boolean isLocked = false;
	private Thread lockedBy = null;
	private int holdCount = 0; // 统计锁的使用
	
	// 使用锁
	public synchronized void lock() throws InterruptedException {
		Thread curT = Thread.currentThread();
		
		while (isLocked && lockedBy != curT) {
			wait();
		}
		
		isLocked = true;
		lockedBy = curT;
		holdCount++;
		
	}
	
	
	
	public int getHoldCount() {
		return holdCount;
	}




	// 释放锁
	public synchronized void unlock() {
		if (Thread.currentThread() == lockedBy) {
			holdCount--;
			if (holdCount==0) {
				isLocked = false;
				notify();
				lockedBy = null;
			}
		}
	}
	
}
