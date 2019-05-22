package com.wendao.thread_status;

/**
 * yield 礼让线程，运行到就绪态。cpu重新调度。
 * @author china
 *
 */
public class YieldDemo01 {
	
	public static void main(String[] args) {
		MyYield my = new MyYield();
		
		new Thread(my, "A").start();
		new Thread(my, "B").start();
	}
	
}

class MyYield implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" start");
		
		Thread.yield(); // 礼让
		
		System.out.println(Thread.currentThread().getName()+" end");
	}
	
}
