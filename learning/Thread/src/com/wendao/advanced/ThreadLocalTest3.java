package com.wendao.advanced;

/**
 * 分析 ThreadLocal 上下文
 * 
 * get/set/initialValue
 * 
 * @author china
 *
 */
public class ThreadLocalTest3 {
	// jdk8
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
	
	public static void main(String[] args) {
		new Thread(new MyRun()).start(); // main调用构造器，而新线程调用run
		// 区分构造器和 run
//		哪里调用构造器，就是哪里的
//		而run方法是属于线程的
	}
	
	/**
	 * 
	 * @author china
	 *
	 */
	public static class MyRun implements Runnable{
		
		public MyRun() {
			threadLocal.set(0);
			System.out.println(Thread.currentThread().getName()+" -> "+
					threadLocal.get());

		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+
					" 剩下-> "+threadLocal.get());
		}
		
	}
}
