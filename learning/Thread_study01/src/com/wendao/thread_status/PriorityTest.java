package com.wendao.thread_status;

/**
 * 线程的优先级 1 ~ 10
 * 1. NORM_PRIORITY 5, default
 * 2. MIN_PRIORITY 1
 * 3. MAX_PRIORITY 10
 * 
 * 为概率
 * 
 * @author china
 *
 */
public class PriorityTest {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+" , priority: "
				+Thread.currentThread().getPriority());
		
		A a = new A();
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(a);
		Thread t3 = new Thread(a);
		Thread t4 = new Thread(a);
		Thread t5 = new Thread(a);
		Thread t6 = new Thread(a);
		Thread t7 = new Thread(a);
		
		// 设置优先级，在start之前
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MIN_PRIORITY);
		t5.setPriority(Thread.MIN_PRIORITY);
		t6.setPriority(Thread.MAX_PRIORITY);
		t7.setPriority(Thread.MAX_PRIORITY);
		
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		
		
		
	}
}

class A implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+" , priority: "+
				Thread.currentThread().getPriority());
		Thread.yield();
		
	}
	
}
