package com.wendao.advanced;


/** 
 * 不可重入锁，案例
 * @author china
 *
 */
public class LockTest01_NotReentrant {
	Lock lock = new Lock();
	
	public void a() throws InterruptedException {
		System.out.println("a begins");
		lock.lock();
		doSth();
		lock.unlock();
		System.out.println("a ends");
	}
	
	public void doSth() throws InterruptedException {
		System.out.println("doSth begins");
		lock.lock();
		// ....
		lock.unlock();
		System.out.println("doSth.ends");
	}
	
	public static void main(String[] args) throws InterruptedException {
		LockTest01_NotReentrant t = new LockTest01_NotReentrant();
		t.a();
		t.doSth();
	}
}


// 不可重入锁
class Lock {
	// 是否占用
	private boolean isLocked = false; 
	
	// 使用锁
	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		
		isLocked = true;
	}
	
	// 释放锁
	public synchronized void unlock() {
		isLocked = false;
		notify();
		
	}
	
	
	
}
