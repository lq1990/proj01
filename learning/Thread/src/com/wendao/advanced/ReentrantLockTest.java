package com.wendao.advanced;

/**
 * 可重入锁
 * 
 * @author china
 *
 */
public class ReentrantLockTest {
	public static void main(String[] args) {
		new ReentrantLockTest().test();
	}
	
	public void test() {
		synchronized (this) {
			while (true) {
				synchronized (this) {// 可重入
					System.out.println("ReentrantLock");
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
