package com.wendao.advanced;

/**
 * 
 * InheritableThreadLocal 可以将数据共享。
 * 
 * 本质上set之后，进行的copy
 * 
 * get/set/initialValue
 * 
 * @author china
 *
 */
public class InheritableThreadLocalTest {
	// jdk8
	private static ThreadLocal<Integer> threadLocal 
		= new InheritableThreadLocal<>();
	
	public static void main(String[] args) {
		threadLocal.set(2);
		System.out.println(Thread.currentThread().getName()+" -> "+ threadLocal.get());
		
		new Thread(() ->{
			System.out.println(Thread.currentThread().getName()+", "+
					threadLocal.get());	 // 2
			
			
			threadLocal.set(99);
			
			System.out.println(Thread.currentThread().getName()+", "+
					threadLocal.get());	 // 99
		}).start();
		
//		new Thread(() ->{
//			System.out.println(Thread.currentThread().getName()+", "+
//					threadLocal.get());	 // 2
//		}).start();

	}
	
	/**
	 * 
	 * @author china
	 *
	 */
	public static class MyRun implements Runnable{
		
		public MyRun() {
//			threadLocal.set(10);
			System.out.println(Thread.currentThread().getName()+" get-> "+
					threadLocal.get());

		}
		
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName()+
					" 剩下-> "+threadLocal.get());
		}
		
	}
}
