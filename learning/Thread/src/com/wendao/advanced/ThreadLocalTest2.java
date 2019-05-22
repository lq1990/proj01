package com.wendao.advanced;

/**
 * 每个线程自身的存储区域。
 * ThreadLocal 中每个线程有自己的工作区，get/set 互不影响。
 * 
 * get/set/initialValue
 * 
 * @author china
 *
 */
public class ThreadLocalTest2 {
	// jdk8
	private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new MyRun()).start();
		}
	}
	
	/**
	 * 
	 * @author china
	 *
	 */
	public static class MyRun implements Runnable{

		@Override
		public void run() {
			Integer left = threadLocal.get();
			System.out.println(Thread.currentThread().getName()+" get-> "+left);
			
			threadLocal.set(left-1);
			System.out.println(Thread.currentThread().getName()+
					" 剩下-> "+threadLocal.get());
		}
		
	}
}
