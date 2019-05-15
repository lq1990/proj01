package com.wendao.advanced;

/**
 * 每个线程自身的存储区域。
 * ThreadLocal 中每个线程有自己的工作区，互不影响。
 * 
 * get/set/initialValue
 * 
 * @author china
 *
 */
public class ThreadLocalTest {
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
	
	// 更改初始值
//	private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
//		protected Integer initialValue() {
//			return 200;
//		}
//	};
	
	// jdk8
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->2000);
	
	public static void main(String[] args) {
		// get
		System.out.println(Thread.currentThread().getName()+" -> "+threadLocal.get());
		
		// set
		threadLocal.set(99);
		System.out.println(Thread.currentThread().getName()+" -> "+threadLocal.get());
		
		new Thread(new MyRun()).start();
		new Thread(new MyRun()).start();
	}
	
	/**
	 * 
	 * @author china
	 *
	 */
	public static class MyRun implements Runnable{

		@Override
		public void run() {
			threadLocal.set((int) (Math.random()*99));
			System.out.println(Thread.currentThread().getName()+" -> "+threadLocal.get());
		}
		
	}
}
